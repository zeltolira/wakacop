package lira.wakacop.pauta.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pauta")
public interface PautaAPI {
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    PautaCadastradaResponse cadastraPauta(@RequestBody novaPautaRequest novaPauta);


}
