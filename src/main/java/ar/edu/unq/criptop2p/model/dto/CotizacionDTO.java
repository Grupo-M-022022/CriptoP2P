package ar.edu.unq.criptop2p.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CotizacionDTO {
    private String symbol;
    private double price;
}
