package lira.wakacop.sessaoVotacao.application.service;

import lira.wakacop.sessaoVotacao.application.api.SessaoAberturaRequest;
import lira.wakacop.sessaoVotacao.application.api.SessaoAberturaResponse;
import lira.wakacop.sessaoVotacao.application.api.VotoRequest;
import lira.wakacop.sessaoVotacao.application.api.VotoResponse;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
    VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto);
}
