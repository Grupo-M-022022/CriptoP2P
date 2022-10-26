package ar.edu.unq.criptop2p.model.entity;

import ar.edu.unq.criptop2p.CriptoP2PApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest extends CriptoP2PApplicationTests {

    Usuario usuario = new Usuario();

    @BeforeEach
    void setUpUsuario() {
        usuario.setEmail("desaCripto@gmail.com");
        usuario.setPassword("criptoPass");
        usuario.setCvuMercadoPago("1234567890123456789012");
        usuario.setDireccion("Bransen 805");
        usuario.setDireccionBilleteraDeCriptoActivos("12345678");
        usuario.setCantidadOperaciones(0);
        usuario.setReputacion(0);
    }

    @Test
    void testModeloUsuario() {
        assertEquals("desaCripto@gmail.com",usuario.getEmail());
        assertEquals("Bransen 805", usuario.getDireccion());
        assertEquals("1234567890123456789012", usuario.getCvuMercadoPago());
        assertEquals("12345678", usuario.getDireccionBilleteraDeCriptoActivos());
        assertEquals(0, usuario.getCantidadOperaciones());
        assertEquals(0, usuario.getReputacion());
    }

}