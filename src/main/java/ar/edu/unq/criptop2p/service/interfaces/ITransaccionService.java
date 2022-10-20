package ar.edu.unq.criptop2p.service.interfaces;

import ar.edu.unq.criptop2p.model.dto.CotizacionBinanceDTO;
import ar.edu.unq.criptop2p.model.dto.CotizacionDTO;
import ar.edu.unq.criptop2p.model.dto.TransaccionDTO;

import java.util.List;

public interface ITransaccionService {
    void transferir(TransaccionDTO transaccionDTO);
}
