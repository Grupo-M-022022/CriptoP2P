package ar.edu.unq.criptop2p.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@Data
public class CriptoMonedaDTO {
    private long id;
    private String nombre;
    private List<CotizacionDTO> cotizaciones;

    public CriptoMonedaDTO(String nombre) {
        setNombre(nombre);
    }
}
