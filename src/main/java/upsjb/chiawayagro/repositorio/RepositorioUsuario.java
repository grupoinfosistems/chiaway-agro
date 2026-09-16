package upsjb.chiawayagro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upsjb.chiawayagro.modelo.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
