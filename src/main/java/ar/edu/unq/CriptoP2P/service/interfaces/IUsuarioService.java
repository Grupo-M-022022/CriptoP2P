package ar.edu.unq.CriptoP2P.service.interfaces;

import java.util.List;
import ar.edu.unq.CriptoP2P.model.dto.UsuarioDTO;

public interface IUsuarioService {
	List<UsuarioDTO> findAll();
	void save(UsuarioDTO usuario);
}
