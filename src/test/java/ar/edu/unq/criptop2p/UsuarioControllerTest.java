package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;

import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import ar.edu.unq.criptop2p.webservice.UsuarioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UsuarioControllerTest extends CriptoP2PApplicationTests {
    private static final String HTTP_LOCALHOST = "http://localhost:";

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
        var listaUsuarios = Objects.requireNonNull(this.restTemplate.getForEntity(HTTP_LOCALHOST + port + "/usuario/usuarios", UsuarioDTO[].class)).getBody();
        assert listaUsuarios != null;
        assertThat(listaUsuarios.length).isGreaterThan(0);
    }

    @Test
    public void verUsuarioRegistradoTest() throws Exception {
        UsuarioDTO usuarioRegistrado = new UsuarioDTO("userRegistrado@gmail.com", "Tucuman 1000", "1234",
                "1234567891234567891234", "12345678");
        var usuarioDTO = usuarioService.save(usuarioRegistrado);
        var usuarioEndToEnd = this.restTemplate.getForEntity(HTTP_LOCALHOST + port + "/usuario/" + usuarioDTO.getId(), UsuarioDTO.class);
        var idUsuarioCreado = Objects.requireNonNull(usuarioEndToEnd.getBody()).getId();
        assertThat(idUsuarioCreado).isNotZero();
    }

    @Test
    public void verSiExisteElUsuarioConID15() throws Exception {
        var idUsuario = this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/usuario/" + "15", UsuarioDTO.class).getId();
        assertThat(idUsuario).isEqualTo(15);
    }

    @Test
    public void verQueNoExisteUnUsuarioConID14() throws Exception {
        assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/usuario/id",
                String.class)).doesNotContain("14");
    }

}


