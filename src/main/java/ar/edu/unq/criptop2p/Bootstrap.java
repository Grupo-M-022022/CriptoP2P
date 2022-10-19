package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.model.dto.CriptoMonedaDTO;
import ar.edu.unq.criptop2p.model.dto.IntencionDTO;
import ar.edu.unq.criptop2p.model.dto.UsuarioDTO;
import ar.edu.unq.criptop2p.service.interfaces.ICotizacionService;
import ar.edu.unq.criptop2p.service.interfaces.ICriptoMonedaService;
import ar.edu.unq.criptop2p.service.interfaces.IIntencionService;
import ar.edu.unq.criptop2p.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class Bootstrap  implements CommandLineRunner {
    @Autowired
    private ICriptoMonedaService criptoMonedaService;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IIntencionService intencionService;
    @Autowired
    private ICotizacionService cotizacionService;

    @Override
    public void run(String... args) throws Exception {

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
        CriptoMonedaDTO cripto1 = criptoMonedaService.save(new CriptoMonedaDTO("TRXUSDT"));
        CriptoMonedaDTO cripto2 = criptoMonedaService.save(new CriptoMonedaDTO("AUDIOUSDT"));

        //setUp
        UsuarioDTO usuario1 = new UsuarioDTO("user1@gmail.com","calle 10 esquina 77","1234" ,
                "1234567891234567891234","12345678");
        UsuarioDTO usuario2 = new UsuarioDTO("user2@hotmail.com","Bransen 805","4321" ,
                "1234567891234567894321","12340000");
        UsuarioDTO usuario3 = new UsuarioDTO("user3@yahoo.com","Zuviria 1024","MedialunasDeJamon" ,
                "1234567891234560000000","10101109");

        usuario1 = usuarioService.save(usuario1);
        //usuarioService.save(usuario2);
        //usuarioService.save(usuario3);

        cripto1 = criptoMonedaService.save(cripto1);

        //criptoMonedaService.save(cripto2);

        IntencionDTO intencion1	=	new IntencionDTO(usuario1,cripto1,"COMPRA",10,20,30);
        //IntencionDTO intencion2 =  	new IntencionDTO(usuario3, cripto2, "VENTA", 50, 100, 80);

        intencionService.save(intencion1);
        //intencionService.save(intencion2);
    }
}