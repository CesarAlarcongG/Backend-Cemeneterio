package com.Backend.BackendCementerio.usuario.registro.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import com.Backend.BackendCementerio.usuario.registro.service.implement.RegistroImplements;

@Service
public class RegistroService implements RegistroImplements{

    @Autowired
    private IUsuarioRepository uRepository;


    @Override
    public boolean verificarExistenciaDeCuenta(String correo) {
        return uRepository.findByCorreo(correo) != null;
    }

    @Override
    public void resgistrarCuenta(Usuario usuario) {
        uRepository.save(usuario);
    }

}
