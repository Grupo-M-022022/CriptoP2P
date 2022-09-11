package ar.edu.unq.CriptoP2P.model.entity;

import java.time.LocalDateTime;

public class Criptomoneda {
	public Criptomoneda(String nombre, Integer precio, LocalDateTime fechaYHoraDeCotizacion) {
		setNombre(nombre);
		setPrecio(precio);
		setFechaYHoraDeCotizacion(fechaYHoraDeCotizacion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public void setFechaYHoraDeCotizacion(LocalDateTime fechaYHoraCotizada) {
		this.fechaYHoraDeCotizacion = fechaYHoraCotizada;
	}

	private String nombre;
	private Integer precio;
	private LocalDateTime fechaYHoraDeCotizacion;
}
