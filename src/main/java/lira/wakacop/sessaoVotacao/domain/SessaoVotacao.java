package lira.wakacop.sessaoVotacao.domain;

import lira.wakacop.pauta.domain.Pauta;
import lira.wakacop.sessaoVotacao.application.api.ResultadoSessaoResponse;
import lira.wakacop.sessaoVotacao.application.api.SessaoAberturaRequest;
import lira.wakacop.sessaoVotacao.application.api.VotoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private UUID idPauta;
    private Integer tempoDuracao;
    @Enumerated(EnumType.STRING)
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;

    @OneToMany(
            mappedBy = "sessaoVotacao",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKey(name = "cpfAssociado")
    private Map<String, VotoPauta> votos;

    public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
        this.idPauta = pauta.getId();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.momentoAbertura = LocalDateTime.now();
        this.momentoEncerramento = momentoAbertura.plusMinutes(this.tempoDuracao);
        this.status = StatusSessaoVotacao.ABERTA;
        this.votos = new HashMap<>();
    }

       public VotoPauta recebeVoto(VotoRequest votoRequest){
        validaSessaoAberta();
        validaAssociado(votoRequest.getCpfAssociado());
        VotoPauta voto = new VotoPauta(this, votoRequest);
        votos.put(votoRequest.getCpfAssociado(), voto);
        return voto;
    }

    private void validaSessaoAberta() {
        atualizaStatus();
        if (this.status.equals(StatusSessaoVotacao.FECHADA)){
            throw new RuntimeException("Sessão está fechada!");
        }
    }

    private void atualizaStatus() {
        if (this.status.equals(StatusSessaoVotacao.ABERTA)){
            if(LocalDateTime.now().isAfter(this.momentoEncerramento)){
                fechaSessao();
            }
        }
    }

    private void fechaSessao() {
        this.status = StatusSessaoVotacao.FECHADA;
    }

    private void validaAssociado(String cpfAssosciado) {
        if (this.votos.containsKey(cpfAssosciado)) {
            throw new RuntimeException("Associado Já votou nessa Sessão!");
        }
    }

    public ResultadoSessaoResponse obtemResultado() {
        atualizaStatus();
        return new ResultadoSessaoResponse(this);
    }

    public Long getTotalVotos() {

        return Long.valueOf(this.votos.size());
    }

    public Long getTotalSim() {
        return calculaVotosPorOpcao(OpcaoVoto.SIM);
    }

    public Long getTotalNao() {
        return calculaVotosPorOpcao(OpcaoVoto.NAO);
    }

    private Long calculaVotosPorOpcao(OpcaoVoto opcao) {
        return votos.values().stream()
                .filter(voto -> voto.opcaoIgual(opcao))
                .count();
    }
}