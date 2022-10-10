package ar.edu.unq.criptop2p.service.interfaces;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import java.util.List;

public interface IIntencionService {

    List<IntencionDTO> findAll();
    void save(IntencionDTO intencion);
    IntencionDTO getById(long id);
}
