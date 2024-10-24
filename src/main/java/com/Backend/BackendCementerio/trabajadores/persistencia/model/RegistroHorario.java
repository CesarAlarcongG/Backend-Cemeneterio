package com.Backend.BackendCementerio.trabajadores.persistencia.model;

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
    private Trabajador trabajador;
}


