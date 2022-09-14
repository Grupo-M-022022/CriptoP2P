package ar.edu.unq.criptop2p.model.entity;

public class Transaccion {
    private Intencion intencion;
    private Usuario usuarioTransaccion;
    private EstadoTransaccion estadoTransaccion;

    public Intencion getIntencion() {
        return intencion;
    }

    public void setIntencion(Intencion intencion) {
        this.intencion = intencion;
    }

    public Usuario getUsuarioTransaccion() {
        return usuarioTransaccion;
    }

    public void setUsuarioTransaccion(Usuario usuarioTransaccion) {
        this.usuarioTransaccion = usuarioTransaccion;
    }

    public EstadoTransaccion getEstado() {
        return estadoTransaccion;
    }

    public void setEstado(EstadoTransaccion estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }
}
