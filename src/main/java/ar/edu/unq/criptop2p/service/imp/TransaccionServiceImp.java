package ar.edu.unq.criptop2p.service.imp;

import ar.edu.unq.criptop2p.exception.CotizacionDesfazadaException;
import ar.edu.unq.criptop2p.model.dto.TransaccionDTO;
import ar.edu.unq.criptop2p.model.entity.Transaccion;
import ar.edu.unq.criptop2p.persistence.interfaces.ITransaccionRepository;
import ar.edu.unq.criptop2p.service.interfaces.ITransaccionService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import ar.edu.unq.criptop2p.utility.enums.EstadoTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionServiceImp implements ITransaccionService {
    @Autowired
    private AutoMapperComponent autoMapper;
    @Autowired
    private ITransaccionRepository transaccionRepository;

    @Override
    public TransaccionDTO save(TransaccionDTO transaccionDTO) {
        Transaccion transactionEntity = autoMapper.To(transaccionDTO, Transaccion.class);
        transaccionRepository.save(transactionEntity);
        return autoMapper.To(transactionEntity, TransaccionDTO.class);
    }

    @Override
    public void transferir(TransaccionDTO transaccionDTO) {
        Transaccion transaccionEntidad = autoMapper.To(transaccionDTO, Transaccion.class);
        try {
            transaccionEntidad.ValidarTransaccion();
            transaccionEntidad.setEstadoTransaccionCompra();
            transaccionEntidad.setDireccionEnvio();
        } catch (CotizacionDesfazadaException ex){
            transaccionEntidad.setEstadoTransaccion(EstadoTransaccion.CANCELADO);
        } finally {
            transaccionRepository.save(transaccionEntidad);
        }
    }

    @Override
    public void recibir(TransaccionDTO transaccionDTO) {
        Transaccion transaccionEntidad = autoMapper.To(transaccionDTO, Transaccion.class);
        try {
            transaccionEntidad.ValidarTransaccion();
            transaccionEntidad.setEstadoTransaccionVenta();
            transaccionEntidad.setDireccionEnvio();
        } catch (CotizacionDesfazadaException ex){
            transaccionEntidad.setEstadoTransaccion(EstadoTransaccion.CANCELADO);
        } finally {
            transaccionRepository.save(transaccionEntidad);
        }
    }
    @Override
    public void cancelar(TransaccionDTO transaccionDTO) {
        Transaccion transaccionEntidad = autoMapper.To(transaccionDTO, Transaccion.class);
        transaccionEntidad.setEstadoTransaccion(EstadoTransaccion.CANCELADO);
        transaccionRepository.save(transaccionEntidad);
    }
}