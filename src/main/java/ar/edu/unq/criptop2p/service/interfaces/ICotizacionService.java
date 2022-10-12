package ar.edu.unq.criptop2p.service.interfaces;

import ar.edu.unq.criptop2p.model.dto.CotizacionDTO;
import java.util.List;

public interface ICotizacionService {
    List<CotizacionDTO> getCotizaciones();
}
