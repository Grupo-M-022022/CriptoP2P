package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.model.entity.Usuario;
import ar.edu.unq.criptop2p.service.imp.UsuarioServiceImp;
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


    private static final String HTTP_LOCALHOST = "http://localhost:8080/usuario/usuarios";
    //agregado el request del swagger
    private static final String HTTP_LOCALHOST_USUARIOID        = "http://localhost:8080/usuario/15" ;
    private static final String HTTP_LOCALHOST_USUARIOREGISTRAR =   "http://localhost:8080/usuario/registrar";


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
        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/usuario/usuarios",
                String.class)).contains("/usuarios");

    }
//    @Test
//    public void verUsuarioRegistradoTest() throws Exception {
//
//        UsuarioDTO usuarioRegistrado = new UsuarioDTO("userRegistrado@gmail.com", "Tucuman 1000", "1234",
//                "1234567891234567891234", "12345678");
//        usuarioController.registrar(usuarioRegistrado);
//
//        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST_USUARIOREGISTRAR + port + "/usuario/registrar",
//                UsuarioDTO.class)).isEqualTo(usuarioRegistrado);//contains("usuarioRegistrado");
//
//    }
//    @Test
//    public void verRegistrarUsuarioTest() throws Exception {
//
//        //UsuarioDTO user = http://localhost:8080/usuario/registrar
//
//        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST_USUARIOID + port + "/usuario/{id}",
//                String.class)).contains("");
//
//    }

}

