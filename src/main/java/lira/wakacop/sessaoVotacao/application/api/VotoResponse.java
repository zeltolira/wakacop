package lira.wakacop.sessaoVotacao.application.api;

import lira.wakacop.sessaoVotacao.domain.VotoPauta;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class VotoResponse {
    private UUID id;
    private UUID idSessao;
    private String cpfAssociado;
    private LocalDateTime momentoVoto;
    public VotoResponse(VotoPauta voto) {
        this.id = voto.getId();
        this.idSessao = voto.getIdSessao();
        this.cpfAssociado = voto.getCpfAssociado();
        this.momentoVoto = voto.getMomentoVoto();
    }
}