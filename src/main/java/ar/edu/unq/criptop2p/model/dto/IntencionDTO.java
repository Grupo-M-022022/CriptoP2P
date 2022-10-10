package ar.edu.unq.criptop2p.model.dto;

import ar.edu.unq.criptop2p.model.entity.Criptomoneda;
import ar.edu.unq.criptop2p.model.entity.Usuario;
import ar.edu.unq.criptop2p.utility.enums.TipoIntencion;
import javax.validation.constraints.NotNull;

public class IntencionDTO {

    private long id;
//    @NotNull
      public UsuarioDTO usuarioConIntencion;
//    @NotNull
//    private Criptomoneda criptoactivo;
//    @NotNull
//    private TipoIntencion operacion;

    @NotNull
    private long cantidad;
    @NotNull
    private double cotizacion;
    @NotNull
    private double monto;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public void setCriptoactivo(Criptomoneda criptoactivo) {
//        this.criptoactivo = criptoactivo;
//    }
//    public Criptomoneda getCriptoactivo() {
//        return criptoactivo;
//    }

    public UsuarioDTO getUsuario() {
        return usuarioConIntencion;
    }
//
//
//
    public void setUsuario(UsuarioDTO usuario) {
        this.usuarioConIntencion = usuario;
    }
//    public TipoIntencion getOperacion() {
//        return operacion;
//    }
//
//    public void setOperacion(TipoIntencion operacion) {
//        this.operacion = operacion;
//    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
