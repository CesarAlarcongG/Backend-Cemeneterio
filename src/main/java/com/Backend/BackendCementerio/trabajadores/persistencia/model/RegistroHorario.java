package com.Backend.BackendCementerio.trabajadores.persistencia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fecha;
    private String horaIngreso;
    private String horaSalida;

    @ManyToOne
    @JoinColumn(name = "trabajador_id")
    @JsonBackReference // Indica que esta es la parte "de regreso" de la relación
    private Trabajador trabajador;
}


