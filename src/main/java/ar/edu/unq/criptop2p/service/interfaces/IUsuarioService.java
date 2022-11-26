package ar.edu.unq.criptop2p.service.interfaces;

import java.util.List;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioService {
	List<UsuarioDTO> findAll();
	UsuarioDTO save(UsuarioDTO usuario);
	UsuarioDTO getById(long id);
}
