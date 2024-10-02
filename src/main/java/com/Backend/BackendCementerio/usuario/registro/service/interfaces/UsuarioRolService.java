package com.Backend.BackendCementerio.usuario.registro.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.BackendCementerio.usuario.persistence.model.Rol;
import com.Backend.BackendCementerio.usuario.persistence.model.RolEnum;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IRolRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UsuarioRolService {
    @Autowired
    private IRolRepository rol;

     @PostConstruct
    public void initDatabase() {
        if (rol.count() == 0) {
            Rol rolUsuario = new Rol();
            rolUsuario.setRol(RolEnum.USUARIO);
            rol.save(rolUsuario);

            Rol rolAdmin = new Rol();
            rolAdmin.setRol(RolEnum.ADMININISTRADOR);
            rol.save(rolAdmin);
        }
    }

}
