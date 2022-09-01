package ar.edu.unq.CriptoP2P.model;

public class Usuario {
	public Usuario(String email, String password, String direccion, Integer CVUMercadoPago,
				   String direccionBilleteraDeCriptoActivos) {
		
		setEmail(email);
		setPassword(password);
		setDireccion(direccion);
		setCVUMercadoPago(CVUMercadoPago); 										  //22 digitos
		setDireccionBilleteraDeCriptoActivos(direccionBilleteraDeCriptoActivos);  //8 digitos
		
		
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
	
	public String getDireccionBilleteraDeCriptoActivos() { //8 digitos
		return direccionBilleteraDeCriptoActivos;
	}
	public void setDireccionBilleteraDeCriptoActivos(String dbc) {
		this.direccionBilleteraDeCriptoActivos = dbc;
	}
	
	private String email;
	private String password;
	private String direccion;
	private Integer CVUMercadoPago;
	private String direccionBilleteraDeCriptoActivos;

}


