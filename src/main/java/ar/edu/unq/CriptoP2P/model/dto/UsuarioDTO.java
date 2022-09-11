package ar.edu.unq.CriptoP2P.model.dto;


public class UsuarioDTO {
    private long Id;
    private String email;
    private String password;
    private String direccion;
    private Integer CVUMercadoPago;
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
    public Integer getCVUMercadoPago() {
        return CVUMercadoPago;
    }

    public void setCVUMercadoPago(Integer cvu) {
        this.CVUMercadoPago = cvu ;
    }

    public String getDireccionBilleteraDeCriptoActivos() {
        return direccionBilleteraDeCriptoActivos;
    }

    public void setDireccionBilleteraDeCriptoActivos(String dbc) {
        this.direccionBilleteraDeCriptoActivos = dbc;
    }
}
