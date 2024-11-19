package com.Backend.BackendCementerio.negocio.persistencia.models;

import com.Backend.BackendCementerio.negocio.persistencia.models.enums.EstadoServicioEnum;
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
public class EstadoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estado_servicio")
    private Long idEstadoServicio;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private EstadoServicioEnum estado;
}
