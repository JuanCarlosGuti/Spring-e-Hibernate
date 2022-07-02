package com.example.consultorio1106;

import com.example.consultorio1106.DAO.Conexion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Consultorio1106Application {



	public static void main(String[] args) {
		Conexion.crearTablas();
		SpringApplication.run(Consultorio1106Application.class, args);
	}



}
