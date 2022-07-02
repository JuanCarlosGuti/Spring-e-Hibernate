package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String DB_JDBC_DRIVER;
    private String DB_URL;
    private String DB_USER;
    private String DB_PASSWORD;


    public Conexion(String DB_JDBC_DRIVER, String DB_URL, String DB_USER, String DB_PASSWORD) {
        this.DB_JDBC_DRIVER = DB_JDBC_DRIVER;
        this.DB_URL = DB_URL;
        this.DB_USER = DB_USER;
        this.DB_PASSWORD = DB_PASSWORD;
    }

    public Conexion() {

        this.DB_JDBC_DRIVER = "org.h2.Driver";
        this.DB_URL = "jdbc:h2:~/bd_Clinica_Dental";
        this.DB_USER = "root";
        this.DB_PASSWORD = "";
    }

    public Connection conectarConBaseDeDatos(){
        Connection connection = null;

        try {
            this.DB_JDBC_DRIVER = "org.h2.Driver";
            this.DB_URL = "jdbc:h2:~/bd_Clinica_Dental";
            this.DB_USER = "root";
            this.DB_PASSWORD = "";
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
