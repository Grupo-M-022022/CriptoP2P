package ar.edu.unq.criptop2p.persistence.interfaces;

import ar.edu.unq.criptop2p.model.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

}
