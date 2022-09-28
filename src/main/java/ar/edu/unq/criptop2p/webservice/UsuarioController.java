package ar.edu.unq.criptop2p.webservice;

import java.util.List;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/registrar")
	public ResponseEntity<UsuarioDTO> registrar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.save(usuarioDTO);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioDTO>> usuarios() {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> getUser(@PathVariable long id) {
		return ResponseEntity.ok(usuarioService.getById(id));
	}
}
