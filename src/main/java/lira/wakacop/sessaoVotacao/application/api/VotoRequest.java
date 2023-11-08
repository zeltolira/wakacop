package lira.wakacop.sessaoVotacao.application.api;

import lira.wakacop.sessaoVotacao.domain.OpcaoVoto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoRequest {
    private String cpfAssosciado;
    private OpcaoVoto opcao;
}
