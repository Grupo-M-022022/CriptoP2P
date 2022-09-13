package ar.edu.unq.criptop2p.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unq.criptop2p.model.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
