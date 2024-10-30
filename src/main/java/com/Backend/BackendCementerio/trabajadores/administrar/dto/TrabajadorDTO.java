package com.Backend.BackendCementerio.trabajadores.administrar.dto;

import com.Backend.BackendCementerio.trabajadores.persistencia.model.Cargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrabajadorDTO {

    private String nombre;
    private String apellido;
    private Long dni;

    private Cargo cargo;
}
