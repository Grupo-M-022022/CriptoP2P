package ar.edu.unq.criptop2p.model.entity;


import ar.edu.unq.criptop2p.utility.enums.EstadoTransaccion;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Transacciones")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;
    @OneToOne
    private Intencion intencion;
    @OneToOne
    private Usuario usuario;
    private EstadoTransaccion estadoTransaccion;
    private double monto;
    private int cantidadOperaciones;
    private int reputacion;
    private String direccionEnvio;
}