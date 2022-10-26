package ar.edu.unq.criptop2p.model.dto;


import ar.edu.unq.criptop2p.utility.enums.EstadoTransaccion;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TransaccionDTO {
    public TransaccionDTO (IntencionDTO intencion, UsuarioDTO usuario, EstadoTransaccion estado ,
                           double monto, int cantidadDeOperaciones,
                           int reputacion, String direccionEnvio) {

        setIntencion(intencion);
        setUsuario(usuario);
        setEstadoTransaccion(estado);
        setMonto(monto);
        setCantidadOperaciones(cantidadDeOperaciones);
        setReputacion(reputacion);
        setDireccionEnvio(direccionEnvio);

    }
    private long id;
    @NotNull
    private IntencionDTO intencion;
    @NotNull
    private UsuarioDTO usuario;
    private EstadoTransaccion estadoTransaccion;
    @NotNull
    private double monto;
    private int cantidadOperaciones;
    private int reputacion;
    private String direccionEnvio;


    public Long getIdUsuario() {
        return getUsuario().getId();
    }
}
