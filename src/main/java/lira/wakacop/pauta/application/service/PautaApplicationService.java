package lira.wakacop.pauta.application.service;

import lira.wakacop.pauta.application.api.PautaCadastradaResponse;
import lira.wakacop.pauta.application.api.novaPautaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    @Override
    public PautaCadastradaResponse cadastraPauta(novaPautaRequest novaPauta) {
        log.info("[inicia] PautaApplicationService - cadastrarPauta");
        log.info("[novaPauta]{}", novaPauta);
        log.info("[finaliza] PautaApplicationService - cadastrarPauta");
        return null;
    }
}
