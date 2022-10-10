package ar.edu.unq.criptop2p.persistence;

import ar.edu.unq.criptop2p.model.entity.Intencion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIntencionRepository  extends JpaRepository<Intencion, Long> {

}
