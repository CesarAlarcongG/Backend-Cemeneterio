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
public class Tumba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tumba")
    private Long idTumba;

    @OneToOne
    @JoinColumn(name = "id_direccion_tumba", referencedColumnName = "id_direccion_tumba")
    private DireccionTumba direccionTumba;  // Cambiar el nombre aquí
}

