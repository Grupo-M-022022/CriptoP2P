package ar.edu.unq.criptop2p.Service;

import ar.edu.unq.criptop2p.CriptoP2PApplicationTests;
import ar.edu.unq.criptop2p.model.dto.CriptoMonedaDTO;
import ar.edu.unq.criptop2p.service.interfaces.ICriptoMonedaService;
import ar.edu.unq.criptop2p.webservice.CriptoActivoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CriptoActivoEndToEndTest extends CriptoP2PApplicationTests {
    private static final String HTTP_LOCALHOST = "http://localhost:";

    @Autowired
    private ICriptoMonedaService criptoMonedaService;

    @LocalServerPort
    private int port;

    @Autowired
    private CriptoActivoController criptoActivoController;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void verCriptomonedasTests() throws Exception {
        var listarCriptos = Objects.requireNonNull(this.restTemplate.getForEntity(HTTP_LOCALHOST + port + "/cotizacion/cotizaciones", CriptoMonedaDTO[].class)).getBody();
        assert listarCriptos != null;
        assertThat(listarCriptos.length).isGreaterThan(0);
    }
}
