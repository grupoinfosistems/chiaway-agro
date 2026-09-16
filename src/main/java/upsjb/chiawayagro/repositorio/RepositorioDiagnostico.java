package upsjb.chiawayagro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upsjb.chiawayagro.modelo.Diagnostico;

public interface RepositorioDiagnostico extends JpaRepository<Diagnostico, Long> {
}
