package ar.edu.unq.criptop2p.model.entity;

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
	private long id;
	private String email;
	private String password;
	private String direccion;
	@Column(length = 22)
	private String cvuMercadoPago;
	@Column(length = 8)
	private String direccionBilleteraDeCriptoActivos;
	public Usuario() {
		// Este constructor es necesario para JPA
	}
	public Usuario(String email, String password, String direccion, String cvuMercadoPago,
				   String direccionBilleteraDeCriptoActivos) {
		
		setEmail(email);
		setPassword(password);
		setDireccion(direccion);
		setCVUMercadoPago(cvuMercadoPago);
		setDireccionBilleteraDeCriptoActivos(direccionBilleteraDeCriptoActivos); 
	}

	public long getId() {
		return this.id;
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
	
	public void setDireccion(String dir) {
		this.direccion = dir;
	}
	public String getCVUMercadoPago() {
		return cvuMercadoPago;
	}
	
	public void setCVUMercadoPago(String cvu) {
		this.cvuMercadoPago = cvu ;
	}
	
	public String getDireccionBilleteraDeCriptoActivos() {
		return direccionBilleteraDeCriptoActivos;
	}
	
	public void setDireccionBilleteraDeCriptoActivos(String dbc) {
		this.direccionBilleteraDeCriptoActivos = dbc;
	}
}


