package lira.wakacop.pauta.application.service;

import lira.wakacop.pauta.application.api.PautaCadastradaResponse;
import lira.wakacop.pauta.application.api.novaPautaRequest;
import lira.wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    private final  PautaRepository pautaRepository;

    @Override
    public PautaCadastradaResponse cadastraPauta(novaPautaRequest novaPauta) {
        log.info("[start] PautaApplicationService - cadastrarPauta");
        log.info("[novaPauta]{}", novaPauta);
        Pauta pauta = pautaRepository.salva(new Pauta(novaPauta));
        log.info("[finish] PautaApplicationService - cadastrarPauta");
        return new PautaCadastradaResponse(pauta);
    }
}
