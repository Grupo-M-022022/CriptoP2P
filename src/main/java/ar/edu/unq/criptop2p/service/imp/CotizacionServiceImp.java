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

import java.util.ArrayList;
import java.util.Date;
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

    @Cacheable("cotizacion") //Agregada las cotizaciones para cache

    public List<CotizacionDTO> getCotizaciones() {
        List<CriptoMoneda> criptoMonedas = criptoModedaRepository.findAll();
        List<CotizacionDTO> cotizacionesDTO = new ArrayList<>();
        for(CriptoMoneda cripto : criptoMonedas){
            CotizacionDTO cotizacion = new CotizacionDTO();
            cotizacion.setSymbol(cripto.getNombre());
            cotizacion.setPrice(cripto.getUltimaCotizacion());
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
            cotizacion.setFechaYHoraDeCotizacion(new Date());
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
            cotizacion.setFechaYHoraDeCotizacion(new Date());
            cotizacion.setCriptoactivo(cripto);
            cripto.addCotizacion(cotizacion);
            criptoModedaRepository.save(cripto);
        }
    }
}