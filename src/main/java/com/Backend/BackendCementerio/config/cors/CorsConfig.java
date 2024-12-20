package com.Backend.BackendCementerio.config.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración de peticiones
 * Este archivo fue creado con la intención de poder configurar la seguridad de recepción de métodos.
 * A modo de prueba hemos consideado recibir cualquier petición desde cualquier servidor.
 */


public class CorsConfig implements WebMvcConfigurer{
/**
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOriginPatterns("*")// Permitir todos los orígenes
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("Authorization") // Si necesitas exponer el token o encabezados personalizados
                .allowCredentials(true);
    }
*/
}
