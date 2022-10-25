package ar.edu.unq.criptop2p.persistence.interfaces;

import ar.edu.unq.criptop2p.model.entity.Intencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IIntencionRepository extends JpaRepository<Intencion, Long> {
    @Query("SELECT i FROM Intencion i WHERE i.activo = true")
    List<Intencion> findAllActiveUsers();
}
