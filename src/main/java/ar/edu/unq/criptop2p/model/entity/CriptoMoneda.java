package ar.edu.unq.criptop2p.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Criptomonedas")
public class CriptoMoneda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;
	private String nombre;
	@OneToMany
	private List<Cotizacion> cotizaciones;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addCotizacion(Cotizacion cotizacion) {
		this.cotizaciones.add(cotizacion);
	}
}
