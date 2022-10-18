package ar.edu.unq.criptop2p.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cotizaciones")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;
    @OneToOne
    private CriptoMoneda criptoactivo;
    private double price;
    private Date fechaYHoraDeCotizacion;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getFechaYHoraDeCotizacion() {
        return fechaYHoraDeCotizacion;
    }

    public Cotizacion(){

    }
    public void setFechaYHoraDeCotizacion(Date fechaYHoraDeCotizacion) {
        this.fechaYHoraDeCotizacion = fechaYHoraDeCotizacion;
    }

    public CriptoMoneda getCriptoactivo() {
        return criptoactivo;
    }

    public void setCriptoactivo(CriptoMoneda criptoactivo) {
        this.criptoactivo = criptoactivo;
    }
}
