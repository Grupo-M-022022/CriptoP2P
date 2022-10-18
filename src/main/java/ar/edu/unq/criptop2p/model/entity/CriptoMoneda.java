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
	@OneToMany(fetch = FetchType.EAGER)
	private List<Cotizacion> cotizaciones;

	public String getNombre() {
		return nombre;
	}
	public CriptoMoneda (){

	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addCotizacion(Cotizacion cotizacion) {
		this.getCotizaciones().add(cotizacion);
	}

	public List<Cotizacion> getCotizaciones() {
		return cotizaciones;
	}

	public void setCotizaciones(List<Cotizacion> cotizaciones) {
		this.cotizaciones = cotizaciones;
	}
}
