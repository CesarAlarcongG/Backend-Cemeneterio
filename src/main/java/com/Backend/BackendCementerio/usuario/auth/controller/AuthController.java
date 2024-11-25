package com.Backend.BackendCementerio.usuario.auth.controller;

import com.Backend.BackendCementerio.config.security.jwt.JwtService;
import com.Backend.BackendCementerio.config.security.jwt.Token.Token;
import com.Backend.BackendCementerio.usuario.General.ResponseController;
import com.Backend.BackendCementerio.usuario.auth.dto.AuthTokenDTO;
import com.Backend.BackendCementerio.usuario.auth.service.AuthService;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private GoogleIdTokenVerifier googleIdTokenVerifier;


    @PostMapping("/google")
    public ResponseEntity<?> authenticateWithGoogle(@RequestBody AuthTokenDTO token) {
        String googleToken = token.getToken();
        try {

            // Verificar el token de Google
            GoogleIdToken idToken = googleIdTokenVerifier.verify(googleToken);

            if (idToken == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
            }

            // Extraer información del usuario desde el token
            GoogleIdToken.Payload payload = idToken.getPayload();
            String email = payload.getEmail();
            String name = (String) payload.get("name");

            // Registrar o autenticar al usuario
            Usuario usuario = authService.findOrRegisterUser(email, name);

            // Generar el JWT
            Token jwt = new Token(jwtService.getToken(usuario));

            //Generamos la clase de respuesta
            ResponseController response = new ResponseController(jwt, usuario);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al autenticar");
        }
    }


}

