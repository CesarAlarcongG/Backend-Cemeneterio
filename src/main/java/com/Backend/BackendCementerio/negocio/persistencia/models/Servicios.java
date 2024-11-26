package com.Backend.BackendCementerio.negocio.persistencia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_servicio")
    private Long idServicio;

    @Column(length = 50)
    private String nombre;

    @OneToMany
    private List<TipoServicio> tipoServicio;

}
