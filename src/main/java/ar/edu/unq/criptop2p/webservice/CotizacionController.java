package ar.edu.unq.criptop2p.webservice;

import ar.edu.unq.criptop2p.model.dto.CotizacionDTO;
import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.service.interfaces.ICotizacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cotizacion")
@Tag(name = "CotizacionController", description = "Operaciones sobre las cotizaciones del sistema")
@SecurityRequirement(name = "Bearer Authentication")
public class    CotizacionController {
@Autowired
    private ICotizacionService cotizacionService;
    @Operation(summary = "Ver las cotizaciones",
            description = "Lista todas las cotizaciones en el sistema")
    @GetMapping("/cotizaciones")
    public ResponseEntity<List<CotizacionDTO>> cotizaciones(){
        return  new ResponseEntity<>(cotizacionService.getCotizaciones(),HttpStatus.OK);
    }
    @Operation(summary = "Ver las ultimas 24 hs de cotizaciones",
            description = "Listar las cotizaciones de las ultimas 24 hs")
    @GetMapping("/{cripto}")
    public ResponseEntity<List<CotizacionDTO>> cotizaciones24Hs(@Parameter(description =
            "nombre de la cripto con sus ultimas 24 hs de cotizacion") @PathVariable String cripto){
        return  new ResponseEntity<>(cotizacionService.cotizarCriptosPorUltimas24Hs(cripto),HttpStatus.OK);
    }
}
