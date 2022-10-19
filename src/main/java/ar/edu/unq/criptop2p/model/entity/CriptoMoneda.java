package ar.edu.unq.criptop2p.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Criptomonedas")
@Data
@NoArgsConstructor
public class CriptoMoneda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;
	private String nombre;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Cotizacion> cotizaciones;

	public void addCotizacion(Cotizacion cotizacion) {
		this.getCotizaciones().add(cotizacion);
	}
}
