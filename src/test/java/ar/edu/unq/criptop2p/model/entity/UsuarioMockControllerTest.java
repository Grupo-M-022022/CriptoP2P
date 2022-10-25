package ar.edu.unq.criptop2p.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class UsuarioMockControllerTest {

        @Mock
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

        private Usuario usuario;

        @BeforeEach

        void setUp(){
            MockitoAnnotations.openMocks(this);
            usuario = new Usuario();

        }

        @Test
        void getUsuarioNuevo() {
            ResponseEntity<Usuario> usuarioResponse = new ResponseEntity<>(usuario, HttpStatus.OK);

            Mockito
                    .when(restTemplate.getForEntity(ArgumentMatchers.anyString(), ArgumentMatchers.eq(Usuario.class)))
                    .thenReturn(usuarioResponse);

            Assertions.assertEquals(HttpStatus.OK, usuarioResponse.getStatusCode());
            Assertions.assertEquals(usuarioResponse.getBody().getEmail(), usuario.getEmail());
            Assertions.assertEquals(usuarioResponse.getBody().getPassword(), usuario.getPassword());
            Assertions.assertEquals(usuarioResponse.getBody().getDireccion(), usuario.getDireccion());
            Assertions.assertEquals(usuarioResponse.getBody().getCvuMercadoPago(), usuario.getCvuMercadoPago());
            Assertions.assertEquals(usuarioResponse.getBody().getDireccionBilleteraDeCriptoActivos(), usuario.getDireccionBilleteraDeCriptoActivos());
        }
    }

