package ar.edu.unq.criptop2p.model.dto;

import java.util.List;

public class CriptoMonedaDTO {
    private long id;
    private String nombre;
    private List<CotizacionDTO> cotizaciones;

    public CriptoMonedaDTO(){

    }
    public CriptoMonedaDTO(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CotizacionDTO> getCotizaciones() {
        return cotizaciones;
    }

    public void setCotizaciones(List<CotizacionDTO> cotizaciones) {
        this.cotizaciones = cotizaciones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
