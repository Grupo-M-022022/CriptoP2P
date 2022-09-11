package ar.edu.unq.CriptoP2P.service.interfaces;

import java.util.List;
import ar.edu.unq.CriptoP2P.model.Usuario;

public interface IUsuarioService {
	List<Usuario> findAll();
	void save(Usuario usuario);
}
