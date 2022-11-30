package ar.edu.unq.criptop2p.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class CotizacionDTO {
    private String symbol;
    private double price;
    private LocalDateTime fechaYHoraDeCotizacion;
}
