package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.webservice.UsuarioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class UsuarioControllerTest {


    private static final String HTTP_LOCALHOST = "http://localhost:";


    @LocalServerPort
    private int port;

    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        assertThat(usuarioController).isNotNull();
    }

    @Test
    public void verUsuariosTest() throws Exception {
                //TODO: Ver porque funciona si se pone vacio.

        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/usuario/usuarios",
                String.class)).contains("");

    }

}

