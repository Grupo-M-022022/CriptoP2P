package ar.edu.unq.criptop2p.persistence.Imp;

import ar.edu.unq.criptop2p.model.entity.Cotizacion;
import ar.edu.unq.criptop2p.persistence.interfaces.ICotizacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Repository
public class CotizacionRepository implements ICotizacionRepository {
    String uri = "https://api1.binance.com/api/v3/ticker/price";

    String[] criptos = new String[] {   "ALICEUSDT",
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


    public Cotizacion[] getCotizaciones() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cotizacion[]> response = restTemplate.getForEntity(uri, Cotizacion[].class);
        Cotizacion[] cotizaciones = response.getBody();
        //TODO filtrar criptos activas
        return cotizaciones;
    }
}
