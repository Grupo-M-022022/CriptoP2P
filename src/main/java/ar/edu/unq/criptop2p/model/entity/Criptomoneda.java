package ar.edu.unq.criptop2p.model.entity;

import java.time.LocalDateTime;

public class Criptomoneda {
	private String nombre;
	private Integer precio;
	private LocalDateTime fechaYHoraDeCotizacion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public LocalDateTime getFechaYHoraDeCotizacion() {
		return fechaYHoraDeCotizacion;
	}

	public void setFechaYHoraDeCotizacion(LocalDateTime fechaYHoraDeCotizacion) {
		this.fechaYHoraDeCotizacion = fechaYHoraDeCotizacion;
	}
}
