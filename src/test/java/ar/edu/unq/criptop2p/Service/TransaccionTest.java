package ar.edu.unq.criptop2p.Service;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.dto.TransaccionDTO;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import ar.edu.unq.criptop2p.service.interfaces.ITransaccionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;

@SpringBootTest
public class TransaccionTest {

    @Autowired
    private IIntencionService intencionService;
    @Autowired
    private ITransaccionService transaccionService;

    @BeforeEach
    void setUpUsuario() {

    }

    @Test
    void transferirTransaccionDeVenta() {
        TransaccionDTO transaccionDTO = new TransaccionDTO();

        IntencionDTO intencionDTO = new IntencionDTO();
        intencionDTO.setId(18);

        transaccionDTO.setIntencion(intencionDTO);

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(15);

        transaccionDTO.setUsuario(usuarioDTO);

        transaccionDTO.setMonto(20);

        transaccionDTO = transaccionService.transferir(transaccionDTO);

        //AssertTrue(transaccionDTO)
    }
}
