package ar.edu.unq.criptop2p.model.dto;

import javax.validation.constraints.NotNull;


public class IntencionDTO {

    private long id;
    @NotNull
      public UsuarioDTO UsuarioConIntencion;
    @NotNull
    private CriptoMonedaDTO criptoactivo;
    @NotNull
    private String operacionDescripcion;

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

    public IntencionDTO (UsuarioDTO usuarioDTO,CriptoMonedaDTO criptoactivoDto, String operacionDescripcion,
                         long cantidad, double cotizacion, double monto){

        setUsuario( usuarioDTO);
        setCriptoactivo(criptoactivoDto);
        setOperacionDescripcion(operacionDescripcion);
        setCantidad(cantidad);
        setCotizacion(cotizacion);
        setMonto(monto);
    }
    public void setCriptoactivo(CriptoMonedaDTO criptoactivo) {
        this.criptoactivo = criptoactivo;
    }
    public CriptoMonedaDTO getCriptoactivo() {
        return criptoactivo;
    }

    public UsuarioDTO getUsuario() {
        return UsuarioConIntencion;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.UsuarioConIntencion = usuario;
    }

    public String getOperacionDescripcion() {
        return operacionDescripcion;
    }

    public void setOperacionDescripcion(String operacionDescripcion) {
        this.operacionDescripcion = operacionDescripcion;
    }

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
