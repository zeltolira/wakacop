package lira.wakacop.associado.application.service;

import lira.wakacop.associado.infra.client.ConsultaCpfResponse;
import lira.wakacop.associado.infra.client.SerproClientFeing;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
    private final SerproClientFeing serproClientFeing;
    @Override
    public void validaAssociadoAptoVoto(String cpfAssosciado) {
        log.info("[start]AssociadoApplicationService - validaAssociadoAptoVoto");
        ConsultaCpfResponse consultaCpfesponse =  serproClientFeing.consultaCPF(TOKEN, cpfAssosciado);
        valida(consultaCpfesponse);
        log.info("[finish]AssociadoApplicationService - validaAssociadoAptoVoto");
    }
    private void valida(ConsultaCpfResponse consultaCpfesponse) {
        if(consultaCpfesponse.isInvalid()){
            throw new RuntimeException("CPF Invalido");
        }
    }

    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";
}
