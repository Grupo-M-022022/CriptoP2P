package ar.edu.unq.criptop2p.webservice;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.dto.TransaccionDTO;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.service.interfaces.ITransaccionService;
import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaccion")
@Tag(name = "TransaccionController", description = "Operaciones sobre las transacciones del sistema")

public class TransaccionController {
    @Autowired
    private ITransaccionService transaccionService;
    @Operation(summary = "Ver las transacciones",
               description = "Mostrar todas las transacciones del sistema")
    @GetMapping("/transacciones")
    public ResponseEntity<List<TransaccionDTO>> intenciones(){
        return  new ResponseEntity<>(transaccionService.findAll(),HttpStatus.OK);
    }
    @Operation(summary = "Realizar una transferencia",
               description = "Permite realizar una transaccion  entre usuarios ")
    @PostMapping("/transferir")
    public ResponseEntity<TransaccionDTO> transferir(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        transaccionDTO = transaccionService.transferir(transaccionDTO);
        return new ResponseEntity<>(transaccionDTO, HttpStatus.CREATED);
    }
    @Operation(summary = "Recibir una transferencia",
            description = "Permite recibir una transaccion  entre usuarios ")
    @PostMapping("/recibir")
    public ResponseEntity<TransaccionDTO> recibir(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        transaccionDTO = transaccionService.recibir(transaccionDTO);
        return new ResponseEntity<>(transaccionDTO, HttpStatus.CREATED);
    }
    @Operation(summary = "Cancelar una transferencia",
               description = "Permite cancelar una transaccion entre usuarios")
    @PostMapping("/cancelar")
    public ResponseEntity<TransaccionDTO> cancelar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        transaccionService.cancelar(transaccionDTO);
        return new ResponseEntity<>(transaccionDTO, HttpStatus.CREATED);
    }
}
