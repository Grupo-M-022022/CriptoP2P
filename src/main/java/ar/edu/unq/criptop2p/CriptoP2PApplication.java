package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.model.dto.CriptoMonedaDTO;
import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.service.interfaces.ICotizacionService;
import ar.edu.unq.criptop2p.service.interfaces.ICriptoMonedaService;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@Data
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CriptoP2PApplication {
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setFieldMatchingEnabled(true)
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
				.setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(CriptoP2PApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {

		};
	}
	@Bean
	InitializingBean sendDatabaseUsuarios() {






		return () -> {



		};
	}

}