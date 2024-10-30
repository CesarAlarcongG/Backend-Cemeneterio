package com.Backend.BackendCementerio.trabajadores.persistencia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "La fecha es obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe estar en formato YYYY-MM-DD")
    private String fecha;

    @NotBlank(message = "La hora de ingreso es obligatoria")
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = "La hora de ingreso debe estar en formato HH:mm")
    private String horaIngreso;

    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = "La hora de salida debe estar en formato HH:mm")
    private String horaSalida;

    @ManyToOne
    @JoinColumn(name = "trabajador_id")
    @JsonBackReference
    private Trabajador trabajador;

}


