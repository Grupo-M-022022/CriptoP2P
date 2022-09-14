package ar.edu.unq.criptop2p.model.entity;

public class Transaccion {
    private Intencion venta;
    private Intencion compra;
    private EstadoTransaccion estadoTransaccion;

    public EstadoTransaccion getEstado() {
        return estadoTransaccion;
    }

    public void setEstado(EstadoTransaccion estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public Intencion getVenta() {
        return venta;
    }

    public void setVenta(Intencion venta) {
        this.venta = venta;
    }

    public Intencion getCompra() {
        return compra;
    }

    public void setCompra(Intencion compra) {
        this.compra = compra;
    }
}
