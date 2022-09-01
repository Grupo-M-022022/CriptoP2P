package ar.edu.unq.CriptoP2P.webservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.CriptoP2P.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@PostMapping("/registrarUsuario")
	public Usuario registrarUsuario(@RequestBody Usuario usuario) {
		Usuario nuevoUsuario = new Usuario(usuario.getEmail(), usuario.getPassword());
		return nuevoUsuario;
	}
	
	@GetMapping("/nombreUsuario")
	public String nombreUsuario() {
		return "Pablo";
	}
}
