package ar.edu.unq.criptop2p.model.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CotizacionDTO {
    private String symbol;
    private double price;

    public CotizacionDTO(String symbol) {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
