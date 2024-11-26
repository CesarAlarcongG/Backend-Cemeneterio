package com.Backend.BackendCementerio.negocio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHorasDto {
    private String horaInicio;
    private String horaFin;
}
