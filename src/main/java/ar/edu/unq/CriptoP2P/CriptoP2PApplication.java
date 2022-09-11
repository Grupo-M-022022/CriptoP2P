package ar.edu.unq.CriptoP2P;

import ar.edu.unq.CriptoP2P.model.dto.UsuarioDTO;
import ar.edu.unq.CriptoP2P.model.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CriptoP2PApplication {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(Usuario.class, UsuarioDTO.class);
		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(CriptoP2PApplication.class, args);
	}

}
