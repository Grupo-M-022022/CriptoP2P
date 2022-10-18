package ar.edu.unq.criptop2p.model.entity;

public class Transaccion {
    private Intencion intencion;
    private Usuario usuario;
    private EstadoTransaccion estadoTransaccion;

    public EstadoTransaccion getEstado() {
        return estadoTransaccion;
    }
    public void setEstado(EstadoTransaccion estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }
    public Intencion getIntencion() {
        return intencion;
    }
    public void setIntencion(Intencion intencion) {
        this.intencion = intencion;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}