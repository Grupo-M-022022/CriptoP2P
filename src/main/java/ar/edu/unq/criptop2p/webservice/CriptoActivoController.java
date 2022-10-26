package ar.edu.unq.criptop2p.webservice;

import ar.edu.unq.criptop2p.model.dto.CotizacionDTO;
import ar.edu.unq.criptop2p.model.dto.CriptoMonedaDTO;
import ar.edu.unq.criptop2p.service.interfaces.ICotizacionService;
import ar.edu.unq.criptop2p.service.interfaces.ICriptoMonedaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/criptomoneda")
@Tag(name = "CriptoActivoController", description = "Operaciones sobre los criptoactivos en el sistema")

public class CriptoActivoController {
    @Autowired
    private ICriptoMonedaService criptoMonedaService;
    @Operation(summary     = "Ver los criptoactivos",
               description = "Mostrar las criptomonedas que estan en el sistema")
    @GetMapping("/criptomonedas")
    public ResponseEntity<List<CriptoMonedaDTO>> criptoMonedas(){
        return  new ResponseEntity<>(criptoMonedaService.findAll(),HttpStatus.OK);
    }
}
