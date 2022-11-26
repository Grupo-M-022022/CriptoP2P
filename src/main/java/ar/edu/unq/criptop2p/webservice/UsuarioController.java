package ar.edu.unq.criptop2p.webservice;

import java.util.List;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
@Tag(name = "UsuarioController", description = "Operaciones sobre los usuarios del sistema")
@EnableAutoConfiguration
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;

	@Operation(summary     = "Registra a un nuevo usuario",
			   description = "Permite ingresar un nuevo usuario al sistema")
	@PostMapping("/registrar")

	public ResponseEntity<UsuarioDTO> registrar(  @Valid @RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.save(usuarioDTO);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
	}
	@Operation(summary     = "Ver a los usuarios",
			   description = "Mostrar los usuarios que estan en el sistema")
	@GetMapping("/usuarios")

	public ResponseEntity<List<UsuarioDTO>> usuarios() {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);

	}
	@Operation(summary 	   = "Buscar a un usuario",
			   description = "Permite buscar a un determinado usuario por su ID")
	@GetMapping("/{id}")

	public ResponseEntity<UsuarioDTO> getUser(@Parameter(description = "ID del usuario a buscar") @PathVariable long id)

	{
		return ResponseEntity.ok(usuarioService.getById(id));
	}
}
