package com.Backend.BackendCementerio.trabajadores.persistencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "El nombre del cargo es obligatorio")
    private String cargo;

    //@NotBlank(message = "La hora de entrada es obligatoria")
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = "La hora debe ser similar a  13:20 o 8:20 ")
    private String horaEntrada;

    //@NotBlank(message = "La hora de salida es obligatoria")
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = "La hora debe ser similar a  13:20 o 8:20 ")
    private String horaSalida;

}
