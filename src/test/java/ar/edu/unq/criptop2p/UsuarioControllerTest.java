package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;

import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import ar.edu.unq.criptop2p.webservice.UsuarioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UsuarioControllerTest extends CriptoP2PApplicationTests {
    private static final String HTTP_LOCALHOST = "http://localhost:8080/usuario/usuarios";
    //agregado el request del swagger
    private static final String HTTP_LOCALHOST_USUARIOID        = "http://localhost:8080/usuario/15" ;
    private static final String HTTP_LOCALHOST_USUARIOREGISTRAR =   "http://localhost:8080/usuario/registrar";

    @Autowired
    private IUsuarioService usuarioService;

    @LocalServerPort
    private int port;

    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void verUsuariosTest() throws Exception {
        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/usuario/usuarios",
                String.class)).contains("/usuarios");
    }

    @Test
    public void verUsuarioRegistradoTest() throws Exception {


        UsuarioDTO usuarioRegistrado = new UsuarioDTO("userRegistrado@gmail.com", "Tucuman 1000", "1234",
                "1234567891234567891234", "12345678");
        usuarioRegistrado.setId(10);
        usuarioService.save(usuarioRegistrado);
        usuarioController.registrar(usuarioRegistrado);

        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST_USUARIOREGISTRAR + port + "/usuario/registrar",
                   UsuarioDTO.class).getId()).isEqualTo(10L);
        //Todo: Puse usuarioDTO porque es lo que pide el assertThat, intente con la variable usuarioControler pero no se puede no se porque
        //Todo: (pide .class) obviamente no funciona porque el usuarioDTO tiene 0 de ID

    }
    @Test
    public void verSiExisteElUsuarioConID15() throws Exception {

        //Ya estan cargados mediante datos de prueba algunos usuarios, uno es con Id 15

        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST_USUARIOID + port + "/usuario/id",
                String.class)).contains("15");

    }
    @Test
    public void verQueNoExisteUnUsuarioConID14() throws Exception {

        //Ya estan cargados mediante datos de prueba algunos usuarios ninguno con ID14

        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST_USUARIOID + port + "/usuario/id",
                String.class)).doesNotContain("14");

    }

}


