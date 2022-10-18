package ar.edu.unq.criptop2p.persistence.Imp;

import ar.edu.unq.criptop2p.model.entity.CotizacionBinance;
import ar.edu.unq.criptop2p.persistence.interfaces.ICotizacionBinanceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CotizacionBinanceBinanceRepository implements ICotizacionBinanceRepository {
    private static final String uri = "https://api1.binance.com/api/v3/ticker/price?symbol=";
    private final String[] criptos = new String[] {   "ALICEUSDT",
                                        "MATICUSDT",
                                        "AXSUSDT",
                                        "AAVEUSDT",
                                        "ATOMUSDT",
                                        "NEOUSDT",
                                        "DOTUSDT",
                                        "ETHUSDT",
                                        "CAKEUSDT",
                                        "BTCUSDT",
                                        "BNBUSDT",
                                        "ADAUSDT",
                                        "TRXUSDT",
                                        "AUDIOUSDT"};


    public List<CotizacionBinance> getCotizaciones() {
        RestTemplate restTemplate = new RestTemplate();
        List<CotizacionBinance> cotizaciones = new ArrayList<>();
        for (String cripto : criptos) {
            ResponseEntity<CotizacionBinance> response = restTemplate.getForEntity(uri + cripto, CotizacionBinance.class);
            cotizaciones.add(response.getBody());
        }
        return cotizaciones;
    }
}
