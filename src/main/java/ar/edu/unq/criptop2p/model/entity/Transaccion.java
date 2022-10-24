package ar.edu.unq.criptop2p.model.entity;


import ar.edu.unq.criptop2p.exception.CotizacionDesfazadaException;
import ar.edu.unq.criptop2p.utility.enums.EstadoTransaccion;
import ar.edu.unq.criptop2p.utility.enums.TipoIntencion;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Transacciones")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;
    @ManyToOne
    private Intencion intencion;
    @ManyToOne
    private Usuario usuario;
    private EstadoTransaccion estadoTransaccion;
    private double monto;
    private int cantidadOperaciones;
    private int reputacion;
    private String direccionEnvio;

    public void setDireccionEnvio() {
        if (esTipoOperacionVenta()){
            setDireccionEnvioVenta();
        } else {
            setDireccionEnvioCompra();
        }
    }

    public boolean esTipoOperacionVenta() {
        return getIntencion().esVenta();
    }

    public void setDireccionEnvioVenta() {
        String cvuDestino = intencion.getUsuarioConIntencion().getCvuMercadoPago();
        setDireccionEnvio(cvuDestino);
    }

    private void setDireccionEnvioCompra() {
        String billeteraDestino = intencion.getUsuarioConIntencion().getDireccionBilleteraDeCriptoActivos();
        setDireccionEnvio(billeteraDestino);
    }

    public void ValidarTransaccion() throws CotizacionDesfazadaException {
        if(esTipoOperacionVenta()){
            if(intencion.getCriptoactivo().getUltimaCotizacion() < monto)
                throw new CotizacionDesfazadaException("La cotización de venta esta por debajo del valor actual");
        } else {
            if (intencion.getCriptoactivo().getUltimaCotizacion() > monto)
                throw new CotizacionDesfazadaException("La cotización de compra esta por encima del valor actual");
        }
    }

    public void setEstadoTransaccionCompra() {
        setEstadoTransaccion(EstadoTransaccion.TRANSFERIDO);
    }

    public void setEstadoTransaccionVenta() {
        setEstadoTransaccion(EstadoTransaccion.RECIBIDO);
    }
}