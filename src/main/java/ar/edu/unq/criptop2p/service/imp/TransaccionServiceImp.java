package ar.edu.unq.criptop2p.service.imp;

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
    public void transferir(TransaccionDTO transaccionDTO) {
        Transaccion transaccionEntidad = autoMapper.To(transaccionDTO, Transaccion.class);
        transaccionEntidad.setEstadoTransaccion(EstadoTransaccion.TRANSFERIDO);
        transaccionEntidad.setDireccionEnvio();
        transaccionRepository.save(transaccionEntidad);
    }
}