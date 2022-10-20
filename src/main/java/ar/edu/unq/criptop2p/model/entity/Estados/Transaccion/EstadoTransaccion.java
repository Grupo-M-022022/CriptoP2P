package ar.edu.unq.criptop2p.model.entity.Estados.Transaccion;

import javax.persistence.*;

@Entity(name="EstadoTransaccion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="estado_type",
        discriminatorType = DiscriminatorType.INTEGER)
public abstract class EstadoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
