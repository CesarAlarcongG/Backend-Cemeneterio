package com.Backend.BackendCementerio.usuario.registro.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Backend.BackendCementerio.usuario.persistence.model.Rol;
import com.Backend.BackendCementerio.usuario.persistence.model.RolEnum;
import com.Backend.BackendCementerio.usuario.persistence.model.Token;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IRolRepository;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import com.Backend.BackendCementerio.usuario.registro.dto.UsuarioDto;
import com.Backend.BackendCementerio.usuario.registro.service.implement.RegistroImplements;
import com.Backend.BackendCementerio.usuario.security.JWT.JwtService;


@Service
public class RegistroService implements RegistroImplements{

    @Autowired
    private IUsuarioRepository uRepository;
    @Autowired
    private IRolRepository rolRepository;
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
    public void registrarRolUsuario (Usuario usuario) {
     
        Rol rolUsuario = rolRepository.findByRol(RolEnum.USUARIO);
        
        usuario.setRol(rolUsuario); 
    }

}
