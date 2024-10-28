package com.Backend.BackendCementerio;


import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import com.Backend.BackendCementerio.trabajadores.persistencia.repository.TrabajadorRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendCementerioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCementerioApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(TrabajadorRespository trabajadorRepository) {
		return args -> {
			// Crear 10 empleados y guardarlos en la base de datos
			trabajadorRepository.save(new Trabajador("Juan", "Perez", 12345678L));
			trabajadorRepository.save(new Trabajador("Maria", "Lopez", 23456789L));
			trabajadorRepository.save(new Trabajador("Carlos", "Garcia", 34567890L));
			trabajadorRepository.save(new Trabajador("Ana", "Martinez", 45678901L));
			trabajadorRepository.save(new Trabajador("Luis", "Fernandez", 56789012L));
			trabajadorRepository.save(new Trabajador("Laura", "Sanchez", 67890123L));
			trabajadorRepository.save(new Trabajador("Jose", "Gomez", 78901234L));
			trabajadorRepository.save(new Trabajador("Elena", "Diaz", 89012345L));
			trabajadorRepository.save(new Trabajador("Miguel", "Ruiz", 90123456L));
		};
	}
}
