package com.Backend.BackendCementerio;


import com.Backend.BackendCementerio.initBD.DatosIniciales;
import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import com.Backend.BackendCementerio.trabajadores.persistencia.repository.TrabajadorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendCementerioApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendCementerioApplication.class, args);

	}
}
