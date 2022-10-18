package ar.edu.unq.criptop2p.persistence.interfaces;

import ar.edu.unq.criptop2p.model.entity.CriptoMoneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICriptoModedaRepository extends JpaRepository<CriptoMoneda, Long> {
    CriptoMoneda findByNombre(String nombre);
}
