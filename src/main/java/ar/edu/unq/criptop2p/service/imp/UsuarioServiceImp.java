package ar.edu.unq.criptop2p.service.imp;

import java.util.List;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unq.criptop2p.model.entity.Usuario;
import ar.edu.unq.criptop2p.persistence.interfaces.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	@Autowired
	private AutoMapperComponent mapperComponent;
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return mapperComponent.ToList(usuarios, UsuarioDTO.class);
	}

	@Override
	public void save(UsuarioDTO usuarioDTO) {
		Usuario usuarioEntity = mapperComponent.To(usuarioDTO, Usuario.class);
		usuarioRepository.save(usuarioEntity);
	}

	@Override
	public UsuarioDTO getById(long id) {
		Usuario usuario = usuarioRepository.getReferenceById(id);
		return mapperComponent.To(usuario, UsuarioDTO.class);
	}
}
