package ar.edu.unq.CriptoP2P.webservice;

import java.util.List;
import ar.edu.unq.CriptoP2P.model.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.CriptoP2P.service.interfaces.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/registrar")
	public ResponseEntity<UsuarioDTO> registrar(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.save(usuarioDTO);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioDTO>> usuarios() {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
	}
}
