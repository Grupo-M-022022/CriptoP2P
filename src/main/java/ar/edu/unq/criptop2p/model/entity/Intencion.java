package ar.edu.unq.criptop2p.model.entity;

import ar.edu.unq.criptop2p.utility.enums.TipoIntencion;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Intenciones")
public class Intencion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;
    @OneToOne
    private CriptoMoneda criptoactivo;
    private long cantidad;
    private double cotizacion;
    private double monto;
    @OneToOne
    private Usuario usuarioConIntencion;
    @Enumerated(EnumType.ORDINAL)
    private TipoIntencion operacion;
    private boolean activo;
    private String operacionDescripcion;
    public String getOperacionDescripcion() {
        return operacion.name();
    }
}

