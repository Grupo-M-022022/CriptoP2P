
package ar.edu.unq.criptop2p.Service;

import ar.edu.unq.criptop2p.CriptoP2PApplicationTests;
import ar.edu.unq.criptop2p.model.dto.CriptoMonedaDTO;
import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.service.interfaces.ICriptoMonedaService;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import ar.edu.unq.criptop2p.webservice.IntencionController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.util.Objects;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IntencionControllerEndToEndTest  extends CriptoP2PApplicationTests {
    private static final String HTTP_LOCALHOST = "http://localhost:";

    @Autowired
    private IIntencionService intencionService;
    @Autowired
    IUsuarioService usuarioService;
    @Autowired
    ICriptoMonedaService criptoMonedaService;

    @LocalServerPort
    private int port;

    @Autowired
    private IntencionController intencionController;

    @Autowired
    private TestRestTemplate restTemplate;



    @Test
    public void verTodasLasIntencionesTest() throws Exception {
        var intenciones = Objects.requireNonNull(this.restTemplate.getForEntity(HTTP_LOCALHOST + port + "/intencion/intenciones", IntencionDTO[].class)).getBody();
        assert intenciones != null;
        assertThat(intenciones.length).isGreaterThan(0);
    }

    @Test
    public void verUnaIntencionRegistradaTest() throws Exception {

        var usuarioParaIntencion = new UsuarioDTO("userRegistrado@gmail.com", "Tucuman 1000", "1234", "1234567891234567891234", "12345678");
        usuarioParaIntencion = usuarioService.save(usuarioParaIntencion);

        var cripto1 = new CriptoMonedaDTO("TRXUSDT");
        cripto1 = criptoMonedaService.save(cripto1);

        var intencionParaRegistrar = new IntencionDTO(usuarioParaIntencion, cripto1, "COMPRA", 70, 0.580, 0.580);
        intencionParaRegistrar = intencionService.save(intencionParaRegistrar);

        var intencionEndToEnd = this.restTemplate.getForEntity(HTTP_LOCALHOST + port + "/intencion/" + intencionParaRegistrar.getId(), IntencionDTO.class);
        var idIntencionCreada = Objects.requireNonNull(intencionEndToEnd.getBody()).getId();
        assertThat(idIntencionCreada).isNotZero();
    }

    @Test
    public void verSiEstaLaIntencionConId18() throws Exception {
        var idIntencion = this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/intencion/" + "18", IntencionDTO.class).getId();
        assertThat(idIntencion).isEqualTo(18);
    }

    @Test
    public void verQueNoExisteUnaIntencionConID1() throws Exception {
        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/intencion/id",
                String.class)).doesNotContain("1");
    }

}
