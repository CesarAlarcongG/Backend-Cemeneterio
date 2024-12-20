package com.Backend.BackendCementerio.negocio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {

    private String fechaReserva;
    private String horaInicio;
    private String horaFin;
    private String intencion;
    private String nombreServicio;
    private Long idFallecido;
    private String correoUsuario;

}
