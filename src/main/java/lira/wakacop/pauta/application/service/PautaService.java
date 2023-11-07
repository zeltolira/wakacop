package lira.wakacop.pauta.application.service;

import lira.wakacop.pauta.application.api.PautaCadastradaResponse;
import lira.wakacop.pauta.application.api.novaPautaRequest;
import lira.wakacop.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaService {
    PautaCadastradaResponse cadastraPauta(novaPautaRequest novaPauta);
    Pauta getPautaPorId(UUID idPauta);
}
