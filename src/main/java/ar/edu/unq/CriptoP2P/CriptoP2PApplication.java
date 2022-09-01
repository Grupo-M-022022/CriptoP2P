package ar.edu.unq.CriptoP2P;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CriptoP2PApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriptoP2PApplication.class, args);
	}

}
