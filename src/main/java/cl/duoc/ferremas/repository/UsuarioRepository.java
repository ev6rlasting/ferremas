package cl.duoc.ferremas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.ferremas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
