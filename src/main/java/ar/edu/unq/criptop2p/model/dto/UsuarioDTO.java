package ar.edu.unq.criptop2p.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class UsuarioDTO {
    public UsuarioDTO(String email,String direccion,String password, String cvuMercadoPago,String direccionBilleteraDeCriptoActivos){
        setEmail(email);
        setPassword(password);
        setDireccion(direccion);
        setCvuMercadoPago(cvuMercadoPago);
        setDireccionBilleteraDeCriptoActivos(direccionBilleteraDeCriptoActivos);
    }

    private long id;
    @NotNull
    @Email
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String direccion;
    @Length(message = "La longitud debe ser de 22 digitos.", min = 22, max = 22)
    @NotNull
    @NotBlank
    private String cvuMercadoPago;
    @Length(message = "La longitud debe ser de 8 digitos.", max = 8, min = 8)
    @NotBlank
    @NotNull
    private String direccionBilleteraDeCriptoActivos;
    private int cantidadOperaciones;
    private int reputacion;
}
