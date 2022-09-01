package ar.edu.unq.CriptoP2P.model;

public class Usuario {
	public Usuario(String email, String password){
		setEmail(email);
		setPassword(password);
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

	private String email;
	private String password;
	
	
}
