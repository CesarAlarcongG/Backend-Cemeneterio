package com.Backend.BackendCementerio.usuario.General;

import com.Backend.BackendCementerio.config.security.jwt.Token.Token;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseController {
    private Token token;
    private Usuario usuario;
}
