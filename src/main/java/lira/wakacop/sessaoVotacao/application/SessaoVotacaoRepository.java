package lira.wakacop.sessaoVotacao.application;

import lira.wakacop.sessaoVotacao.domain.SessaoVotacao;

public interface SessaoVotacaoRepository {
    SessaoVotacao salva(SessaoVotacao sessaoVotacao);
}
