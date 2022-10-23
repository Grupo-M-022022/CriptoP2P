package ar.edu.unq.criptop2p.service.imp;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;

import ar.edu.unq.criptop2p.model.entity.Intencion;
import ar.edu.unq.criptop2p.persistence.interfaces.IIntencionRepository;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class IntencionServiceImp implements IIntencionService {
    @Autowired
    private AutoMapperComponent autoMapper;
    @Autowired
    private IIntencionRepository intencionRepository;

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
    public IntencionDTO save(IntencionDTO intencionDTO) {
        Intencion intencionEntity = autoMapper.To(intencionDTO, Intencion.class);
        intencionEntity.setActivo(true);
        intencionRepository.save(intencionEntity);
        return autoMapper.To(intencionEntity, IntencionDTO.class);
    }

    @Override
    public  IntencionDTO getById(long id){
        Intencion intencion = intencionRepository.getReferenceById(id);
        return autoMapper.To(intencion, IntencionDTO.class);
    }
}