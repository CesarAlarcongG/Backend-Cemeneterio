package com.Backend.BackendCementerio.fallecidos.persistence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DireccionTumba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_direccion_tumba")
    private Long idDireccionTumba;

    private String sector;
    private String nombrePanteon;

    @OneToOne(mappedBy = "direccionTumba")
    private Tumba tumba;
}

