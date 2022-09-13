package ar.edu.unq.CriptoP2P.model.dto;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class UsuarioDTO {
    private long Id;
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

    @Length(min = 22, max = 22)
    @NotNull
    @NotBlank
    private String CVUMercadoPago;
    @Length(max = 8, min = 8)
    @NotBlank
    @NotNull
    private String direccionBilleteraDeCriptoActivos;

    public UsuarioDTO() {}

    public long getId() {
        return this.Id;
    }

    public void setId(long id) {
        this.Id = id;
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

    public void setDireccion(String dir) {
        this.direccion = dir;
    }
    public String getCVUMercadoPago() {
        return CVUMercadoPago;
    }

    public void setCVUMercadoPago(String cvu) {
        this.CVUMercadoPago = cvu ;
    }

    public String getDireccionBilleteraDeCriptoActivos() {
        return direccionBilleteraDeCriptoActivos;
    }

    public void setDireccionBilleteraDeCriptoActivos(String dbc) {
        this.direccionBilleteraDeCriptoActivos = dbc;
    }
}
