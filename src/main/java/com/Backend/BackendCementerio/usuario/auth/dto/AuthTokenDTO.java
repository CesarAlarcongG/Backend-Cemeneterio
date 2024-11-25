package com.Backend.BackendCementerio.usuario.auth.dto;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthTokenDTO {
    private String token;
}
