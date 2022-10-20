package ar.edu.unq.criptop2p.model.dto;

import ar.edu.unq.criptop2p.model.entity.Intencion;
import ar.edu.unq.criptop2p.model.entity.Usuario;
import ar.edu.unq.criptop2p.utility.enums.EstadoTransaccion;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TransaccionDTO {
    private long id;
    private Intencion intencion;
    private Usuario usuario;
    private EstadoTransaccion estadoTransaccion;
    private double monto;
    private int cantidadOperaciones;
    private int reputacion;
    private String direccionEnvio;
}
