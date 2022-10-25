package ar.edu.unq.criptop2p.persistence.interfaces;

import ar.edu.unq.criptop2p.model.entity.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICotizacionRepository extends JpaRepository<Cotizacion, Long> {

}
