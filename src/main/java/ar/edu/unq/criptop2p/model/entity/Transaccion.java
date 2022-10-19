package ar.edu.unq.criptop2p.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaccion {
    private Intencion intencion;
    private Usuario usuario;
    private EstadoTransaccion estadoTransaccion;
}