package ar.edu.unq.criptop2p.persistence.interfaces;

import ar.edu.unq.criptop2p.model.entity.Cotizacion;
import ar.edu.unq.criptop2p.model.entity.Intencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ICotizacionRepository extends JpaRepository<Cotizacion, Long> {


    @Query("SELECT i FROM Cotizacion i WHERE i.fechaYHoraDeCotizacion >= :fechaInicio AND i.fechaYHoraDeCotizacion <= :fechaHasta AND i.criptoactivo.nombre = :nombre")
    List<Cotizacion> cotizacionesEnLasUltimas24hs(@Param("fechaInicio" )LocalDateTime fechaInicio, @Param("fechaHasta" )LocalDateTime fechaHasta ,@Param("nombre") String nombre);


}
