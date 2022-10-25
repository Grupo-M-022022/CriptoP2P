package ar.edu.unq.criptop2p.persistence.Imp;

import ar.edu.unq.criptop2p.model.entity.CotizacionBinance;
import ar.edu.unq.criptop2p.model.entity.CriptoMoneda;
import ar.edu.unq.criptop2p.persistence.interfaces.ICotizacionBinanceRepository;
import ar.edu.unq.criptop2p.persistence.interfaces.ICriptoModedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CotizacionBinanceRepository implements ICotizacionBinanceRepository {
    @Autowired
    private ICriptoModedaRepository criptoModedaRepository;
    private static final String uri = "https://api1.binance.com/api/v3/ticker/price?symbol=";

    public List<CotizacionBinance> getCotizaciones() {
        RestTemplate restTemplate = new RestTemplate();
        List<CotizacionBinance> cotizaciones = new ArrayList<>();
        List<CriptoMoneda> criptoActivos = criptoModedaRepository.findAll();
        for (CriptoMoneda cripto : criptoActivos) {
            ResponseEntity<CotizacionBinance> response = restTemplate.getForEntity(uri + cripto.getNombre(), CotizacionBinance.class);
            cotizaciones.add(response.getBody());
        }
        return cotizaciones;
    }
}
