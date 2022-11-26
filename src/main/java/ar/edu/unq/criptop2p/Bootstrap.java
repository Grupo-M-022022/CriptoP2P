package ar.edu.unq.criptop2p;

import ar.edu.unq.criptop2p.model.dto.*;
import ar.edu.unq.criptop2p.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import static ar.edu.unq.criptop2p.utility.enums.EstadoTransaccion.TRANSFERIDO;

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
    private ITransaccionService transaccionService;
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
        var cripto1 = criptoMonedaService.save(new CriptoMonedaDTO("TRXUSDT"));
        var cripto2 = criptoMonedaService.save(new CriptoMonedaDTO("AUDIOUSDT"));


        //setUp
        UsuarioDTO usuario1 = new UsuarioDTO("user1@gmail.com", "calle 10 esquina 77", "1234",
                "1234567891234567891234", "12345678");
        UsuarioDTO usuario2 = new UsuarioDTO("user2@hotmail.com", "Bransen 805", "4321",
                "1234567891234567894321", "12340000");
        UsuarioDTO usuario3 = new UsuarioDTO("user3@yahoo.com", "Zuviria 1024", "MedialunasDeJamon",
                "1234567891234560000000", "10101109");

        usuario1 = usuarioService.save(usuario1);
        usuario2 = usuarioService.save(usuario2);
        usuario3 = usuarioService.save(usuario3);

        cripto1 = criptoMonedaService.save(cripto1);
        cripto2 = criptoMonedaService.save(cripto2);

        IntencionDTO intencion1 = new IntencionDTO(usuario1, cripto1, "COMPRA", 10, 0.180, 0.180);
        IntencionDTO intencion2 = new IntencionDTO(usuario2, cripto2, "VENTA", 50, 100, 80);
        IntencionDTO intencion3 = new IntencionDTO(usuario3, cripto1, "VENTA", 300, 500, 100);

        intencion1 = intencionService.save(intencion1);
        intencion2 = intencionService.save(intencion2);
        intencion3 = intencionService.save(intencion3);



        TransaccionDTO transaccion1 = new TransaccionDTO (intencion1 , usuario1, TRANSFERIDO ,
                                                         500, 25, 170,
                                                         "25 de Mayo 339");
        cotizacionService.actualizarCotizaciones();
    }
}
