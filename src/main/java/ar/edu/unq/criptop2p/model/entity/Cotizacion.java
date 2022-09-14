package ar.edu.unq.criptop2p.model.entity;

import java.util.Date;

public class Cotizacion {
    private Criptomoneda criptoactivo;
    private Date fechaHora;
    private double cotizacion;

    public Criptomoneda getCriptoactivo() {
        return criptoactivo;
    }

    public void setCriptoactivo(Criptomoneda criptoactivo) {
        this.criptoactivo = criptoactivo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getValorCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(double cotizacion) {
        this.cotizacion = cotizacion;
    }
}
