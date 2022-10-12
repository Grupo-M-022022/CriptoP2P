package ar.edu.unq.criptop2p.service.imp;

import ar.edu.unq.criptop2p.model.dto.CotizacionDTO;
import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.entity.Cotizacion;
import ar.edu.unq.criptop2p.model.entity.Intencion;
import ar.edu.unq.criptop2p.persistence.interfaces.ICotizacionRepository;
import ar.edu.unq.criptop2p.persistence.interfaces.IIntencionRepository;
import ar.edu.unq.criptop2p.service.interfaces.ICotizacionService;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CotizacionServiceImp implements ICotizacionService {
    @Autowired
    private AutoMapperComponent autoMapper;
    @Autowired
    ICotizacionRepository cotizacionRepository;

    public List<CotizacionDTO> getCotizaciones() {
        Cotizacion[] cotizaciones = cotizacionRepository.getCotizaciones();
        return autoMapper.ToList(Arrays.stream(cotizaciones).toList(), CotizacionDTO.class);
    }
}