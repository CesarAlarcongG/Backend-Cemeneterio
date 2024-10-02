package com.Backend.BackendCementerio.negocio.persistencia.models;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido; // Actualizado
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class ReservaTumba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaReserva;
    private Double costo;
    private String tipoTumba;
    private String ubicacionTumba; 

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

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getTipoTumba() {
        return tipoTumba;
    }

    public void setTipoTumba(String tipoTumba) {
        this.tipoTumba = tipoTumba;
    }

    public String getUbicacionTumba() {
        return ubicacionTumba;
    }

    public void setUbicacionTumba(String ubicacionTumba) {
        this.ubicacionTumba = ubicacionTumba;
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


