package com.Backend.BackendCementerio.usuario.registro.service.implement;


import com.Backend.BackendCementerio.usuario.persistence.model.Token;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.registro.dto.UsuarioDto;


public interface RegistroImplements {   
    boolean verificarExistenciaDeCuenta(String correo);

    Token resgistrarCuenta(UsuarioDto usuarioDto);

    void registrarRolUsuario(Usuario usuario);
    
    boolean validarFormatoCorreo(String correo);
}
