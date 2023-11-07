package lira.wakacop.sessaoVotacao.infra;

import lira.wakacop.sessaoVotacao.domain.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessaoVotacaoSpringJPARepository extends JpaRepository<SessaoVotacao, UUID> {
}
