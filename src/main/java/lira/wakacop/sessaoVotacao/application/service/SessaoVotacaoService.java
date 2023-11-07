package lira.wakacop.sessaoVotacao.application.service;

import lira.wakacop.sessaoVotacao.application.api.SessaoAberturaRequest;
import lira.wakacop.sessaoVotacao.application.api.SessaoAberturaResponse;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}
