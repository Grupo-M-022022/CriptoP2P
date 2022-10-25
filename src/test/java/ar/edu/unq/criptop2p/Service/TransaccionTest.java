package ar.edu.unq.criptop2p.Service;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.dto.TransaccionDTO;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import ar.edu.unq.criptop2p.service.interfaces.ITransaccionService;
import ar.edu.unq.criptop2p.utility.enums.EstadoTransaccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TransaccionTest {

    @Autowired
    private IIntencionService intencionService;
    @Autowired
    private ITransaccionService transaccionService;

    private TransaccionDTO transaccionDTO;
    private IntencionDTO intencionDTO;
    private UsuarioDTO usuarioDTO;
    @BeforeEach
    void setTransaccion() {
        transaccionDTO = new TransaccionDTO();

        intencionDTO = new IntencionDTO();
        intencionDTO.setId(18);

        transaccionDTO.setIntencion(intencionDTO);

        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(15);

        transaccionDTO.setUsuario(usuarioDTO);

        transaccionDTO.setMonto(20);
    }

    @Test
    void transferirTransaccionDeVenta() {
        transaccionDTO = transaccionService.transferir(transaccionDTO);
        assertEquals(transaccionDTO.getEstadoTransaccion(), EstadoTransaccion.TRANSFERIDO);
        assertEquals(transaccionDTO.getDireccionEnvio(), "10101109" );
    }

    @Test
    void transferirTransaccionDeCompra() {

        intencionDTO = new IntencionDTO();
        intencionDTO.setId(19);

        transaccionDTO.setIntencion(intencionDTO);
        transaccionDTO.setMonto(0.180);
        transaccionDTO = transaccionService.transferir(transaccionDTO);
        assertEquals(transaccionDTO.getEstadoTransaccion(), EstadoTransaccion.TRANSFERIDO);
        assertEquals(transaccionDTO.getDireccionEnvio(), "1234567891234567894321");
    }
}
