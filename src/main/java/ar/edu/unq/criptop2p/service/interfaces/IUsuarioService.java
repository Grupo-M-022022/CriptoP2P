package ar.edu.unq.criptop2p.service.interfaces;

import java.util.List;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;

public interface IUsuarioService {
	List<UsuarioDTO> findAll();
	void save(UsuarioDTO usuario);
	UsuarioDTO getById(long id);
}
