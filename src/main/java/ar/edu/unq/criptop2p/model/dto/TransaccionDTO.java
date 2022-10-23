package ar.edu.unq.criptop2p.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TransaccionDTO {
    public TransaccionDTO (IntencionDTO intencion, UsuarioDTO usuario, EstadoDTO estado ,
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
    @NotBlank
    private IntencionDTO intencion;
    @NotNull
    @NotBlank
    private UsuarioDTO usuario;
    @NotNull
    @NotBlank
    private EstadoDTO estadoTransaccion;  //para probar si persiste, seteo recibido
    private double monto;
    private int cantidadOperaciones;
    private int reputacion;
    private String direccionEnvio;



}
