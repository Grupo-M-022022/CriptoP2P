package ar.edu.unq.CriptoP2P.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unq.CriptoP2P.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
