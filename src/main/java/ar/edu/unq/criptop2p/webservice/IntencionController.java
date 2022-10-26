package ar.edu.unq.criptop2p.webservice;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/intencion")
@Tag(name = "IntencionController", description = "Operaciones sobre las intenciones en el sistema")

public class IntencionController {

    @Autowired
    private IIntencionService intencionService;
    @Operation(summary     = "Registrar una intencion",
               description = "Registra una nueva intencion en el sistema")

    @PostMapping("/operar")

    public ResponseEntity <IntencionDTO> operar(@Valid @RequestBody IntencionDTO intencionDTO){
        intencionDTO = intencionService.save(intencionDTO);
        return  new ResponseEntity<>(intencionDTO, HttpStatus.CREATED);
    }
    @Operation(summary     = "Ver las intenciones",
            description = "Visualizar todas las intenciones del sistema")
    @GetMapping("/intenciones")

    public ResponseEntity<List<IntencionDTO>> intenciones(){
        return  new ResponseEntity<>(intencionService.findAllActive(),HttpStatus.OK);
    }
    @Operation(summary = "Buscar una intencion",
            description = "Permite buscar a una determinada intencion por su ID")
    @GetMapping("/{id}")

    public ResponseEntity<IntencionDTO> getIntencion(@Parameter(description = "ID de la intencion requerida")@PathVariable long id){
        return  ResponseEntity.ok(intencionService.getById(id));
    }
}
