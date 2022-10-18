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
import ar.edu.unq.criptop2p.service.interfaces.ICriptoMonedaService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CotizacionServiceImp implements ICotizacionService {
    @Autowired
    private AutoMapperComponent autoMapper;
    @Autowired
    private ICotizacionRepository cotizacionRepository;
    @Autowired
    ICotizacionBinanceRepository cotizacionBinanceRepository;
    @Autowired
    private ICriptoModedaRepository criptoModedaRepository;

    public List<CotizacionDTO> getCotizaciones() {
        List<Cotizacion> cotizaciones = cotizacionRepository.findAll();
        return autoMapper.ToList(cotizaciones, CotizacionDTO.class);
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
}