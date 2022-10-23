package ar.edu.unq.criptop2p.webservice;

import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/intencion")
public class IntencionController {

    @Autowired
    private IIntencionService intencionService;

    @PostMapping("/operar")
    public ResponseEntity <IntencionDTO> operar(@Valid @RequestBody IntencionDTO intencionDTO){
        intencionService.save(intencionDTO);
        return  new ResponseEntity<>(intencionDTO, HttpStatus.CREATED);
    }

    @GetMapping("/intenciones")
    public ResponseEntity<List<IntencionDTO>> intenciones(){
        return  new ResponseEntity<>(intencionService.findAllActive(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntencionDTO> getIntencion(@PathVariable long id){
        return  ResponseEntity.ok(intencionService.getById(id));
    }
}
