package ar.edu.unq.criptop2p.service.interfaces;

import ar.edu.unq.criptop2p.model.dto.TransaccionDTO;
import ar.edu.unq.criptop2p.model.entity.Transaccion;

import java.util.List;


public interface ITransaccionService {
    TransaccionDTO save(TransaccionDTO transaccion);
    TransaccionDTO transferir(TransaccionDTO transaccionDTO);
    void recibir(TransaccionDTO transaccionDTO);
    void cancelar(TransaccionDTO transaccionDTO);
    List<TransaccionDTO> findAll();
}
