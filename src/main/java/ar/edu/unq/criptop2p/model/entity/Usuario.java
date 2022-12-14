package ar.edu.unq.criptop2p.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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
	private int cantidadOperaciones;
	private int reputacion;

	@Override
	public String toString(){
		return "Usuario";
	}

    public void PenalidadReputacion() {
		setCantidadOperaciones(getCantidadOperaciones() - 20);
    }

	public void SumarOperacion() {
		setCantidadOperaciones(getCantidadOperaciones()+1);
	}

    public void EncriptarPassword(BCryptPasswordEncoder bCryptPasswordEncoder) {
		String passworEncoded = bCryptPasswordEncoder.encode(this.getPassword());
		this.setPassword(passworEncoded);
    }
}


