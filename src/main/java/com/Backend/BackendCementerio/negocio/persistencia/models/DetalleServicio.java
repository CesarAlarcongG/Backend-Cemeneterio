package com.Backend.BackendCementerio.negocio.persistencia.models;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
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
public class DetalleServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalleServicio;

    private String fechaReserva;

    private String horaInicio;

    private String horaFin;

    private String intencion;

    private float totalPagar;

    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private Servicios servicios;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fallecido", referencedColumnName = "id_fallecido")
    private Fallecido fallecido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado_servicio", referencedColumnName = "id_estado_servicio")
    private EstadoServicio estadoServicio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;


}
