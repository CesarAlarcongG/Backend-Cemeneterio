package com.Backend.BackendCementerio.trabajadores.persistencia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;
    private Long dni; // Este es el código del trabajador

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
    @JsonManagedReference // Indica que esta es la parte "administrada" de la relación
    private List<RegistroHorario> registroHorarios = new ArrayList<>();
}


