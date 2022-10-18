package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.model.dto.CriptoMonedaDTO;
import ar.edu.unq.criptop2p.service.interfaces.ICriptoMonedaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CriptoP2PApplication {

	@Autowired
	private ICriptoMonedaService criptoMonedaService;

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
			criptoMonedaService.save(new CriptoMonedaDTO("ALICEUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("MATICUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("AXSUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("AAVEUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("ATOMUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("NEOUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("DOTUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("ETHUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("CAKEUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("BTCUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("BNBUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("ADAUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("TRXUSDT"));
			criptoMonedaService.save(new CriptoMonedaDTO("AUDIOUSDT"));
		};
	}
}