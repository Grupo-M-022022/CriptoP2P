package ar.edu.unq.CriptoP2P.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long Id;
	private String email;
	private String password;
	private String direccion;
	
	@Column(length = 22)
	private Integer CVUMercadoPago;
	
	@Column(length = 8)
	private String direccionBilleteraDeCriptoActivos;
	
	public Usuario() {}
	
	public Usuario(String email, String password, String direccion, Integer CVUMercadoPago,
				   String direccionBilleteraDeCriptoActivos) {
		
		setEmail(email);
		setPassword(password);
		setDireccion(direccion);
		setCVUMercadoPago(CVUMercadoPago); 										  
		setDireccionBilleteraDeCriptoActivos(direccionBilleteraDeCriptoActivos); 
	}

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


