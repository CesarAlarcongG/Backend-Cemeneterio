package com.Backend.BackendCementerio.usuario.auth.service;


import com.Backend.BackendCementerio.usuario.persistence.model.Enums.PermisoEnum;
import com.Backend.BackendCementerio.usuario.persistence.model.Enums.RolEnum;
import com.Backend.BackendCementerio.usuario.persistence.model.Permisos;
import com.Backend.BackendCementerio.usuario.persistence.model.Rol;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IPermisosRepository;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IRolRepository;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IRolRepository rolRepository;
    @Autowired
    private IPermisosRepository permisosRepository;

    public Usuario findOrRegisterUser(String correo, String name) {
        return usuarioRepository.findByCorreo(correo)
                .orElseGet(() -> {
                    Usuario newUser = new Usuario();
                    newUser.setCorreo(correo);
                    newUser.setNombre(name);

                    //Indicamos os permisos
                    Set<Permisos> permisos = new HashSet<>();

                    permisos.add(permisosRepository.findByPermiso(PermisoEnum.LEER));
                    permisos.add(permisosRepository.findByPermiso(PermisoEnum.CREAR));
                    permisos.add(permisosRepository.findByPermiso(PermisoEnum.ACTUALIZAR));

                    permisos.forEach(permiso -> {
                        if (permiso.getIdPermiso() == null) {
                            permisosRepository.save(permiso); // Guarda los permisos si no están guardados aún
                        }
                    });

                    //Buscamos el rol en la BD
                    Rol rol = rolRepository.findByRol(RolEnum.USUARIO);
                    rol.setPermisos(permisos);
                    newUser.setRol(rol);



                    return usuarioRepository.save(newUser);
                });
    }

}
