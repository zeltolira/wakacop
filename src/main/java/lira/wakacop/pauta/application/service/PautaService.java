package lira.wakacop.pauta.application.service;

import lira.wakacop.pauta.application.api.PautaCadastradaResponse;
import lira.wakacop.pauta.application.api.novaPautaRequest;

public interface PautaService {
    PautaCadastradaResponse cadastraPauta(novaPautaRequest novaPauta);
}
