package ar.edu.unq.criptop2p.service.imp;

import ar.edu.unq.criptop2p.exception.CotizacionDesfazadaException;
import ar.edu.unq.criptop2p.model.dto.TransaccionDTO;
import ar.edu.unq.criptop2p.model.entity.Intencion;
import ar.edu.unq.criptop2p.model.entity.Transaccion;
import ar.edu.unq.criptop2p.model.entity.Usuario;
import ar.edu.unq.criptop2p.persistence.interfaces.IIntencionRepository;
import ar.edu.unq.criptop2p.persistence.interfaces.ITransaccionRepository;
import ar.edu.unq.criptop2p.persistence.interfaces.IUsuarioRepository;
import ar.edu.unq.criptop2p.service.interfaces.ITransaccionService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import ar.edu.unq.criptop2p.utility.enums.EstadoTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransaccionServiceImp implements ITransaccionService {
    @Autowired
    private AutoMapperComponent autoMapper;
    @Autowired
    private ITransaccionRepository transaccionRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IIntencionRepository intencionRepository;

    @Override
    public TransaccionDTO save(TransaccionDTO transaccionDTO) {
        Transaccion transaccionEntidad = autoMapper.To(transaccionDTO, Transaccion.class);
        Optional<Usuario> usuario = usuarioRepository.findById(transaccionEntidad.getIdUsuario());
        transaccionEntidad.setUsuario(usuario.orElse(null));
        transaccionRepository.save(transaccionEntidad);
        //transaccionRepository.getReferenceById(transaccionEntidad.getId());
        transaccionEntidad.setEstadoTransaccion(EstadoTransaccion.INDEFINIDO);
        transaccionEntidad.setDireccionEnvio();
        return autoMapper.To(transaccionEntidad, TransaccionDTO.class);
    }

    @Override
    public TransaccionDTO transferir(TransaccionDTO transaccionDTO) {
        Transaccion transaccionEntidad = autoMapper.To(transaccionDTO, Transaccion.class);
        Optional<Usuario> usuario = usuarioRepository.findById(transaccionEntidad.getIdUsuario());
        transaccionEntidad.setUsuario(usuario.orElse(null));
        Optional<Intencion> intencion = intencionRepository.findById(transaccionEntidad.getIntencion().getId());
        transaccionEntidad.setIntencion(intencion.orElse(null));
        try {
            transaccionEntidad.ValidarTransaccion();
            transaccionEntidad.setEstadoTransaccionTransferido();
            transaccionEntidad.setDireccionEnvio();
            transaccionEntidad.SumarOperacionACompra();
        } catch (CotizacionDesfazadaException ex) {
            transaccionEntidad.getIntencion().setActivo(false);
            transaccionEntidad.setEstadoTransaccion(EstadoTransaccion.CANCELADO);
        }
//        usuario = usuarioRepository.findById(transaccionEntidad.getIdUsuario());
//        transaccionEntidad.setUsuario(usuario.orElse(null));
//        intencion = intencionRepository.findById(transaccionEntidad.getIntencion().getId());
//        transaccionEntidad.setIntencion(intencion.orElse(null));
        transaccionEntidad = transaccionRepository.save(transaccionEntidad);
        return autoMapper.To(transaccionEntidad, TransaccionDTO.class);
    }

    @Override
    @Transactional
    public TransaccionDTO recibir(TransaccionDTO transaccionDTO) {
        Optional<Transaccion> transaccionEntidadOption = transaccionRepository.findById(transaccionDTO.getId());
        Transaccion transaccionEntidad = transaccionEntidadOption.orElse(null);
        assert transaccionEntidad != null;
        transaccionEntidad.setEstadoTransaccionRecibido();
        transaccionEntidad.setDireccionEnvio();
        transaccionEntidad.SumarOperacionAVenta();
        transaccionEntidad.getIntencion().setActivo(false);
        transaccionEntidad = transaccionRepository.save(transaccionEntidad);
        return autoMapper.To(transaccionEntidad, TransaccionDTO.class);
    }

    @Override
    public void cancelar(TransaccionDTO transaccionDTO) {
        Transaccion transaccionEntidad = transaccionRepository.getReferenceById(transaccionDTO.getId());
        transaccionEntidad.setEstadoTransaccion(EstadoTransaccion.CANCELADO);
        transaccionEntidad.PenalidadReputaciones();
        transaccionEntidad.getIntencion().setActivo(false);
        transaccionRepository.save(transaccionEntidad);
    }

    @Override
    public List<TransaccionDTO> findAll() {
        List<Transaccion> intenciones = transaccionRepository.findAll();
        return autoMapper.ToList(intenciones , TransaccionDTO.class);
    }
}