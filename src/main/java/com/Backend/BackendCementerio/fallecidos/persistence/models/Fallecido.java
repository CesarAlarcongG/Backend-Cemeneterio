
package com.Backend.BackendCementerio.fallecidos.persistence.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Fallecido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFallecido;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private Date fechaFallecimiento;

    // Getters y Setters
    public Long getIdFallecido() {
        return idFallecido;
    }

    public void setIdFallecido(Long idFallecido) {
        this.idFallecido = idFallecido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }
}