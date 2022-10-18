package ar.edu.unq.criptop2p.model.entity;

public class CotizacionBinance {
    private double price;
    private String symbol;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
