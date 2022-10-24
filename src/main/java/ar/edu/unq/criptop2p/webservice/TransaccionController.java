package ar.edu.unq.criptop2p.webservice;

import ar.edu.unq.criptop2p.model.dto.TransaccionDTO;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.service.interfaces.ITransaccionService;
import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    @Autowired
    private ITransaccionService transaccionService;

    @PostMapping("/transferir")
    public ResponseEntity<TransaccionDTO> transferir(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        transaccionService.transferir(transaccionDTO);
        return new ResponseEntity<>(transaccionDTO, HttpStatus.CREATED);
    }

    @PostMapping("/recibir")
    public ResponseEntity<TransaccionDTO> recibir(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        transaccionService.recibir(transaccionDTO);
        return new ResponseEntity<>(transaccionDTO, HttpStatus.CREATED);
    }

    @PostMapping("/cancelar")
    public ResponseEntity<TransaccionDTO> cancelar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        transaccionService.cancelar(transaccionDTO);
        return new ResponseEntity<>(transaccionDTO, HttpStatus.CREATED);
    }
}
