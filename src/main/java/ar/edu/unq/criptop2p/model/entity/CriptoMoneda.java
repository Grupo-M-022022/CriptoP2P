package ar.edu.unq.criptop2p.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Criptomonedas")
@NoArgsConstructor
public class CriptoMoneda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("fechaYHoraDeCotizacion DESC")
	private List<Cotizacion> cotizaciones;
	private double ultimaCotizacion;
	@Override
	public String toString(){
		return "CriptoMoneda";
	}
	public void addCotizacion(Cotizacion cotizacion) {
		this.getCotizaciones().add(cotizacion);
	}

	public double getUltimaCotizacion() {
		if (getCotizaciones() != null && (long) getCotizaciones().size() > 0)
			return getCotizaciones().get(0).getPrice();
		return 0;
	}

	public void setUltimaCotizacion(double ultimaCotizacion) {
		this.ultimaCotizacion = ultimaCotizacion;
	}

	public List<Cotizacion> getCotizaciones() {
		return cotizaciones;
	}

	public void setCotizaciones(List<Cotizacion> cotizaciones) {
		this.cotizaciones = cotizaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
