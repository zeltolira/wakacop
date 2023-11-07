package lira.wakacop.pauta.application.service;

import lira.wakacop.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaRepository {
    Pauta salva(Pauta pauta);
    Pauta buscaPautaPorId(UUID idPauta);
}
