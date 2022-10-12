package ar.edu.unq.criptop2p.persistence.interfaces;

import ar.edu.unq.criptop2p.model.entity.Cotizacion;

import java.util.List;

public interface ICotizacionRepository {
    Cotizacion[] getCotizaciones();
}
