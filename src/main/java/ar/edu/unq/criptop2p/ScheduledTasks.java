package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.service.interfaces.ICotizacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    @Autowired
    private ICotizacionService cotizacionService;

    @Scheduled(fixedRate = 100000, initialDelay = 5000)
    public void ActualizarCotizaciones() {
        log.info("ActualizarCotizaciones");
        cotizacionService.actualizarCotizaciones();
    }
}
