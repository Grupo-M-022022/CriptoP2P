package ar.edu.unq.criptop2p.service.imp;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.entity.Intencion;
import ar.edu.unq.criptop2p.persistence.interfaces.IIntencionRepository;
import ar.edu.unq.criptop2p.persistence.interfaces.IUsuarioRepository;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IntencionServiceImp implements IIntencionService {
    @Autowired
    private AutoMapperComponent autoMapper;
    @Autowired
    private IIntencionRepository intencionRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public List<IntencionDTO> findAll() {
        List<Intencion> intenciones = intencionRepository.findAll();
        return autoMapper.ToList(intenciones ,IntencionDTO.class);
    }

    @Override
    public List<IntencionDTO> findAllActive() {
        List<Intencion> intenciones = intencionRepository.findAllActiveUsers();
        return autoMapper.ToList(intenciones ,IntencionDTO.class);
    }

    @Override
    @Transactional
    public IntencionDTO save(IntencionDTO intencionDTO) {
        Intencion intencionEntity = autoMapper.To(intencionDTO, Intencion.class);

        //TODO validacion margen de variación de +/- 5% con respecto a la última cotización actualizada en el sistema
        var porcentaje = intencionEntity.getCriptoactivo().getUltimaCotizacion() * 5 / 100;
        var limiteMenos = intencionEntity.getMonto() - porcentaje;
        var limiteMas = intencionEntity.getMonto() + porcentaje;

        if ((intencionEntity.getMonto() < limiteMenos) || (intencionEntity.getMonto() > limiteMas)){
            //throw new Exception("variacion invalida");
        }
        intencionEntity.setActivo(true);
        intencionRepository.save(intencionEntity);
        return autoMapper.To(intencionEntity, IntencionDTO.class);
    }

    @Override
    public  IntencionDTO getById(long id){
        Optional<Intencion> intencion = intencionRepository.findById(id);
        return autoMapper.To(intencion.orElse(null), IntencionDTO.class);
    }
}