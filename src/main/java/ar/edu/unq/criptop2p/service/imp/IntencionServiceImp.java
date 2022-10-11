package ar.edu.unq.criptop2p.service.imp;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.entity.Intencion;
import ar.edu.unq.criptop2p.persistence.IIntencionRepository;
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
    IIntencionRepository intencionRepository;
    @Override
    public List<IntencionDTO> findAll() {
        List<Intencion> intenciones = intencionRepository.findAll();
        return autoMapper.ToList(intenciones ,IntencionDTO.class);
    }

    @Override
    public void save(IntencionDTO intencionDTO) {
        Intencion intencionEntity = autoMapper.To(intencionDTO, Intencion.class);
        intencionRepository.save(intencionEntity);
    }
    @Override
    public  IntencionDTO getById(long id){
        Intencion intencion = intencionRepository.getReferenceById(id);
        return autoMapper.To(intencion, IntencionDTO.class);
    }
}