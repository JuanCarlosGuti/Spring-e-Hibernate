package com.dh.clase2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Clase22Application {

	public static void main(String[] args) {
		cargarBD();
		SpringApplication.run(Clase22Application.class, args);

	}
	private static void cargarBD(){
		Connection connection = null;
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:~/ejemplotreceJunio;"+
					"INIT=RUNSCRIPT FROM 'create.sql'","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}


	}

}
