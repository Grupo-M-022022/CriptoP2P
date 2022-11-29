package ar.edu.unq.criptop2p.service.interfaces;

import ar.edu.unq.criptop2p.model.dto.CotizacionBinanceDTO;
import ar.edu.unq.criptop2p.model.dto.CotizacionDTO;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ICotizacionService {
    List<CotizacionDTO> getCotizaciones();
    List<CotizacionBinanceDTO> getCotizacionesBinance();
    void save(CotizacionDTO usuario);
    void actualizarCotizaciones();
    List<CotizacionDTO> cotizarCriptosPorUltimas24Hs(String nombreCripto);
}
