package lira.wakacop.pauta.application.api;

import lira.wakacop.pauta.application.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/pauta")
public class PautaController implements PautaAPI {
    private final PautaService pautaService;

    @Override
    public PautaCadastradaResponse cadastraPauta(novaPautaRequest novaPauta) {
        log.info("[inicia] PautaController - cadastrarPauta");
        PautaCadastradaResponse pautaCadastrada = pautaService.cadastraPauta(novaPauta);
        log.info("[finaliza] PautaController - cadastrarPauta");
        return pautaCadastrada;
    }
}
