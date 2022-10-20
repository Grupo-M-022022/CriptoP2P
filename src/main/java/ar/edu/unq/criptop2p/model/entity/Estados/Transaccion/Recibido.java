package ar.edu.unq.criptop2p.model.entity.Estados.Transaccion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Recibido extends EstadoTransaccion {
}
