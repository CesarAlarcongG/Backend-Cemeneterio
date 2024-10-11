package com.Backend.BackendCementerio.negocio.persistencia.models;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido; 
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class ReservaMisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaReserva;
    private String intencion;
    private Double costo;
    private String tipoMisa;
    private int tiempoMisa; 

    private String descripcion; 

    @ManyToOne
    @JoinColumn(name = "fallecido_id")
    private Fallecido fallecido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getIntencion() {
        return intencion;
    }

    public void setIntencion(String intencion) {
        this.intencion = intencion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getTipoMisa() {
        return tipoMisa;
    }

    public void setTipoMisa(String tipoMisa) {
        this.tipoMisa = tipoMisa;
    }

    public int getTiempoMisa() {
        return tiempoMisa;
    }

    public void setTiempoMisa(int tiempoMisa) {
        this.tiempoMisa = tiempoMisa;
    }

    public String getDescripcion() {
        return descripcion; 
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; 
    }

    public Fallecido getFallecido() {
        return fallecido;
    }

    public void setFallecido(Fallecido fallecido) {
        this.fallecido = fallecido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
