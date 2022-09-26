package ar.edu.unq.criptop2p.model.entity;

import ar.edu.unq.criptop2p.utility.enums.TipoIntencion;

public class Intencion {
    private Criptomoneda criptoactivo;
    private long cantidad;
    private double cotizacion;
    private double monto;
    private Usuario Usuario;
    private TipoIntencion operacion;
    private boolean activo;

    public Criptomoneda getCriptoactivo() {
        return criptoactivo;
    }

    public void setCriptoactivo(Criptomoneda criptoactivo) {
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

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario) {
        Usuario = usuario;
    }

    public TipoIntencion getOperacion() {
        return this.operacion;
    }

    public int getCantidadOperaciones() {
        return getUsuario().getCantidadOperaciones();
    }

    public int getReputacion() {
        return getUsuario().getReputacion();
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
}
