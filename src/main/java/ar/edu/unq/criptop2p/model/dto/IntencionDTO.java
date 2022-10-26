package ar.edu.unq.criptop2p.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class IntencionDTO {
    private long id;
    @NotNull
    public UsuarioDTO usuarioConIntencion;
    @NotNull
    private CriptoMonedaDTO criptoactivo;
    private String tipoOperacionDescripcion;
    @NotNull
    private long cantidad;
    @NotNull
    private double cotizacion;
    @NotNull
    private double monto;

    public IntencionDTO (UsuarioDTO usuarioDTO,CriptoMonedaDTO criptoactivoDto, String operacionDescripcion,
                         long cantidad, double cotizacion, double monto){
        setUsuarioConIntencion(usuarioDTO);
        setCriptoactivo(criptoactivoDto);
        setTipoOperacionDescripcion(operacionDescripcion);
        setCantidad(cantidad);
        setCotizacion(cotizacion);
        setMonto(monto);
    }
}
