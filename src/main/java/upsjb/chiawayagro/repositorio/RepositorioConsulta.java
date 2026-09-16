package upsjb.chiawayagro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upsjb.chiawayagro.modelo.Consulta;

public interface RepositorioConsulta extends JpaRepository<Consulta, Long> {
}
