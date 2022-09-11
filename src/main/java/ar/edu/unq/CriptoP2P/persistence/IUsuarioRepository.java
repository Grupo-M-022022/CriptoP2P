package ar.edu.unq.CriptoP2P.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unq.CriptoP2P.model.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
