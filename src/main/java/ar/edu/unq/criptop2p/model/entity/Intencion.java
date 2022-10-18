package ar.edu.unq.criptop2p.model.entity;

import ar.edu.unq.criptop2p.utility.enums.TipoIntencion;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Intenciones")
public class Intencion {
    public Intencion() {
        // Este constructor es necesario para JPA
    }
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

    public CriptoMoneda getCriptoactivo() {
        return criptoactivo;
    }
    public void setCriptoactivo(CriptoMoneda criptoactivo) {
        this.criptoactivo = criptoactivo;
    }
    public long getCantidad() {
        return cantidad;
    }
    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
    public double getCotizacion() {
        return this.cotizacion;
    }
    public void setCotizacion(double cotizacion) {
        this.cotizacion = cotizacion;
    }
    public double getMonto() { return monto; }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public void setUsuarioConIntencion(Usuario usuarioConIntencion) {
        this.usuarioConIntencion = usuarioConIntencion;
    }
    public Usuario getUsuarioConIntencion() { return usuarioConIntencion; }
    public TipoIntencion getOperacion() {
        return operacion;
    }
    public boolean sActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public void setOperacion(TipoIntencion operacion) {
        this.operacion = operacion;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public boolean isActivo() {
        return activo;
    }
}

