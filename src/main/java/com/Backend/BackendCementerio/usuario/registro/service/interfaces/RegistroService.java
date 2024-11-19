package com.Backend.BackendCementerio.usuario.registro.service.interfaces;

import com.Backend.BackendCementerio.usuario.persistence.model.Enums.PermisoEnum;
import com.Backend.BackendCementerio.usuario.persistence.model.Permisos;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IPermisosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Backend.BackendCementerio.usuario.persistence.model.Rol;
import com.Backend.BackendCementerio.usuario.persistence.model.Enums.RolEnum;
import com.Backend.BackendCementerio.config.security.jwt.Token.Token;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IRolRepository;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import com.Backend.BackendCementerio.usuario.registro.dto.UsuarioDto;
import com.Backend.BackendCementerio.usuario.registro.service.implement.RegistroImplements;
import com.Backend.BackendCementerio.config.security.jwt.JwtService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class RegistroService implements RegistroImplements{

    @Autowired
    private IUsuarioRepository uRepository;
    @Autowired
    private IRolRepository rolRepository;
    @Autowired
    private IPermisosRepository permisosRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean validarFormatoCorreo(String correo) {

        String EMAIL_PATTERN = "^[\\w+_.-]+@[\\w.-]+\\.[a-zA-Z]{2,7}$";


        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(EMAIL_PATTERN);

        if (correo == null) {
            return false;  
        }

        java.util.regex.Matcher matcher = pattern.matcher(correo);

        return matcher.matches(); 
    }

    @Override
    public boolean verificarExistenciaDeCuenta(String correo) {
        return uRepository.findByCorreo(correo).isPresent();
    }

    /**
     * Método que almacena un usuario y llama a otro método para indicar el rol
     */

    @Override
    public Token resgistrarCuenta(UsuarioDto usDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usDto.getNombre());
        usuario.setApellido(usDto.getApellido());
        usuario.setCorreo(usDto.getCorreo());

        // Codificar la contraseña
        usuario.setContraseña(passwordEncoder.encode(usDto.getContraseña())); 
        registrarRolUsuario(usuario);
        uRepository.save(usuario);

        Token token = new Token(jwtService.getToken(usuario));
        return token;
    }

    @Override
    public void registrarRolUsuario(Usuario usuario) {
        Rol rolUsuario = rolRepository.findByRol(RolEnum.USUARIO);
        rolUsuario.setPermisos(registrarPermisos());
        rolRepository.save(rolUsuario);  // Guarda el rol con los permisos

        usuario.setRol(rolUsuario);
        uRepository.save(usuario);  // Guarda el usuario con el rol actualizado
    }

    public Set<Permisos> registrarPermisos(){
        Set<Permisos> permisos = new HashSet<>();
        permisos.add(permisosRepository.findByPermiso(PermisoEnum.LEER));
        permisos.add(permisosRepository.findByPermiso(PermisoEnum.CREAR));
        permisos.add(permisosRepository.findByPermiso(PermisoEnum.ACTUALIZAR));
        return permisos;
    }

}
