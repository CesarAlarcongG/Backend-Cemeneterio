package com.Backend.BackendCementerio.trabajadores.asistencia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CredencialesDTO {

    private Long dni;
    private String hora;
    private String fecha;
}
