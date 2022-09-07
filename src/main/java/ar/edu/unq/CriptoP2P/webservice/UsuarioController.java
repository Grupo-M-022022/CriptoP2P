package ar.edu.unq.CriptoP2P.webservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.CriptoP2P.model.Usuario;
import ar.edu.unq.CriptoP2P.persistence.IUsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@PostMapping("/registrarUsuario")
	public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
		Usuario nuevoUsuario = new Usuario(usuario.getEmail(), usuario.getPassword(), usuario.getDireccion(), 
								           usuario.getCVUMercadoPago(), usuario.getDireccionBilleteraDeCriptoActivos());
		usuarioRepository.save(nuevoUsuario);
		return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> usuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
}
