package ar.edu.unq.CriptoP2P.service.imp;

import java.util.List;

import ar.edu.unq.CriptoP2P.model.dto.UsuarioDTO;
import ar.edu.unq.CriptoP2P.service.interfaces.IUsuarioService;
import ar.edu.unq.CriptoP2P.utility.AutoMapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unq.CriptoP2P.model.entity.Usuario;
import ar.edu.unq.CriptoP2P.persistence.IUsuarioRepository;

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

}
