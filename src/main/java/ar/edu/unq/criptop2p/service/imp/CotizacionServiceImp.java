package ar.edu.unq.criptop2p.service.imp;

import ar.edu.unq.criptop2p.model.dto.CotizacionBinanceDTO;
import ar.edu.unq.criptop2p.model.dto.CotizacionDTO;
import ar.edu.unq.criptop2p.model.entity.Cotizacion;
import ar.edu.unq.criptop2p.model.entity.CotizacionBinance;
import ar.edu.unq.criptop2p.model.entity.CriptoMoneda;
import ar.edu.unq.criptop2p.persistence.interfaces.ICotizacionBinanceRepository;
import ar.edu.unq.criptop2p.persistence.interfaces.ICotizacionRepository;
import ar.edu.unq.criptop2p.persistence.interfaces.ICriptoModedaRepository;
import ar.edu.unq.criptop2p.service.interfaces.ICotizacionService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CotizacionServiceImp implements ICotizacionService {
    @Autowired
    private AutoMapperComponent autoMapper;
    @Autowired
    private ICotizacionRepository cotizacionRepository;
    @Autowired
    ICotizacionBinanceRepository cotizacionBinanceRepository;
    @Autowired
    private ICriptoModedaRepository criptoModedaRepository;

    @Cacheable(value = "cotizacionesCache")
    public List<CotizacionDTO> getCotizaciones() {
        List<CriptoMoneda> criptoMonedas = criptoModedaRepository.findAll();
        List<CotizacionDTO> cotizacionesDTO = new ArrayList<>();
        for (CriptoMoneda cripto : criptoMonedas) {
            CotizacionDTO cotizacion = new CotizacionDTO();
            cotizacion.setSymbol(cripto.getNombre());
            cotizacion.setPrice(cripto.getUltimaCotizacion());
            cotizacion.setFechaYHoraDeCotizacion(cripto.getCotizaciones().get(0).getFechaYHoraDeCotizacion());
            cotizacionesDTO.add(cotizacion);
        }
        return cotizacionesDTO;
    }

    @Override
    public List<CotizacionBinanceDTO> getCotizacionesBinance() {
        List<CotizacionBinance> cotizaciones = cotizacionBinanceRepository.getCotizaciones();
        for (CotizacionBinance cotizacionBinance : cotizaciones) {
            CriptoMoneda cripto = criptoModedaRepository.findByNombre(cotizacionBinance.getSymbol());
            Cotizacion cotizacion = new Cotizacion();
            cotizacion.setPrice(cotizacionBinance.getPrice());
            cotizacion.setFechaYHoraDeCotizacion(LocalDateTime.now());
            cotizacion.setCriptoactivo(cripto);
            cotizacionRepository.save(cotizacion);
            cripto.addCotizacion(cotizacion);
            criptoModedaRepository.save(cripto);
        }
        return autoMapper.ToList(cotizaciones, CotizacionBinanceDTO.class);
    }

    @Override
    public void save(CotizacionDTO cotizacion) {
        cotizacionRepository.save(autoMapper.To(cotizacion, Cotizacion.class));
    }

    @Override
    public void actualizarCotizaciones() {
        List<CotizacionBinance> cotizaciones = cotizacionBinanceRepository.getCotizaciones();
        for (CotizacionBinance cotizacionBinance : cotizaciones) {
            CriptoMoneda cripto = criptoModedaRepository.findByNombre(cotizacionBinance.getSymbol());
            Cotizacion cotizacion = new Cotizacion();
            cotizacion.setPrice(cotizacionBinance.getPrice());
            cotizacion.setFechaYHoraDeCotizacion(LocalDateTime.now());
            cotizacion.setCriptoactivo(cripto);
            cripto.addCotizacion(cotizacion);
            criptoModedaRepository.save(cripto);
        }
    }

    @Override
    public List<CotizacionDTO> cotizarCriptosPorUltimas24Hs(String nombreCripto) {
        LocalDateTime fechaHasta = LocalDateTime.now();
        LocalDateTime fechaInicio = LocalDateTime.now().minusHours(24);
        List<Cotizacion> cotizaciones24Hs = cotizacionRepository.cotizacionesEnLasUltimas24hs(fechaInicio, fechaHasta, nombreCripto);
        return autoMapper.ToList(cotizaciones24Hs, CotizacionDTO.class);
    }
}