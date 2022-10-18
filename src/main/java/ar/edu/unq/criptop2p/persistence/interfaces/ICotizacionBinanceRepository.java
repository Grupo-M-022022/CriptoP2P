package ar.edu.unq.criptop2p.persistence.interfaces;

import ar.edu.unq.criptop2p.model.entity.CotizacionBinance;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICotizacionBinanceRepository {
    List<CotizacionBinance> getCotizaciones();
}
