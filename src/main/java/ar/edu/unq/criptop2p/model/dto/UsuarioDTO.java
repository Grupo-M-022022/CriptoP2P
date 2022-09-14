package ar.edu.unq.criptop2p.model.dto;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;

public class UsuarioDTO {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCvuMercadoPago() {
        return cvuMercadoPago;
    }

    public void setCvuMercadoPago(String cvuMercadoPago) {
        this.cvuMercadoPago = cvuMercadoPago;
    }

    public String getDireccionBilleteraDeCriptoActivos() {
        return direccionBilleteraDeCriptoActivos;
    }

    public void setDireccionBilleteraDeCriptoActivos(String direccionBilleteraDeCriptoActivos) {
        this.direccionBilleteraDeCriptoActivos = direccionBilleteraDeCriptoActivos;
    }
}
