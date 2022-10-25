package ar.edu.unq.criptop2p.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
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

    public IntencionDTO (UsuarioDTO usuarioDTO,CriptoMonedaDTO criptoactivoDto, String operacionDescripcion,
                         long cantidad, double cotizacion, double monto){
        setUsuarioConIntencion( usuarioDTO);
        setCriptoactivo(criptoactivoDto);
        setOperacionDescripcion(operacionDescripcion);
        setCantidad(cantidad);
        setCotizacion(cotizacion);
        setMonto(monto);
    }
}
