package com.Backend.BackendCementerio.usuario.loggin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredencialesUsuarioDTO {
    private String correo;
    private String contraseña;
}
