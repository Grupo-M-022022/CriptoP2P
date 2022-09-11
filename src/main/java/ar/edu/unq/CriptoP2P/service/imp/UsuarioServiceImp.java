package ar.edu.unq.CriptoP2P.service.imp;

import java.util.List;

import ar.edu.unq.CriptoP2P.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unq.CriptoP2P.model.Usuario;
import ar.edu.unq.CriptoP2P.persistence.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

}
