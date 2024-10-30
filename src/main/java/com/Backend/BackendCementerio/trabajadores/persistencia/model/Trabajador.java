package com.Backend.BackendCementerio.trabajadores.persistencia.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Es requerido el nombre")
    private String nombre;

    @NotBlank(message = "Es requerido el apellido")
    private String apellido;

    @NotNull(message = "No se puede proceder si no digita el DNI")
    @Positive(message = "El DNI debe ser un número positivo")
    private Long dni;

    @OneToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RegistroHorario> registroHorarios = new ArrayList<>();





    //Es constructor es de ejemplo, podemos eliminarlo (su función es recibir 10 empleados)
    public Trabajador(String nombre, String apellidos, Long dni){
        this.nombre = nombre;
        this.apellido = apellidos;
        this.dni = dni;
    }
}


