package com.Backend.BackendCementerio.usuario.registro.service.implement;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;

public interface RegistroImplements {   
    boolean verificarExistenciaDeCuenta(String correo);
    void resgistrarCuenta(Usuario usuario);
}
