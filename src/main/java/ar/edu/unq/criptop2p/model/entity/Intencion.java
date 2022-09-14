package ar.edu.unq.criptop2p.model.entity;

import ar.edu.unq.criptop2p.utility.enums.TipoIntencion;

public class Intencion {
    private Criptomoneda criptoactivo;
    private long cantidad;
    private Cotizacion cotizacion;
    private double monto;
    private Usuario Usuario;
    private TipoIntencion Operación;
    private boolean Activo;

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

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public ar.edu.unq.criptop2p.model.entity.Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(ar.edu.unq.criptop2p.model.entity.Usuario usuario) {
        Usuario = usuario;
    }

    public TipoIntencion getOperación() {
        return Operación;
    }

    public void setOperación(TipoIntencion operación) {
        Operación = operación;
    }

    public int getCantidadOperaciones() {
        return getUsuario().getCantidadOperaciones();
    }

    public byte getReputación() {
        return getUsuario().getReputacion();
    }

    public boolean sActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }
}
