package com.Backend.BackendCementerio.usuario.registro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;

}
