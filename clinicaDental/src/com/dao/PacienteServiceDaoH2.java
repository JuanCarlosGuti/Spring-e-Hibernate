package com.dao;

import com.model.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteServiceDaoH2 implements IDao<Paciente> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/bd_Clinica_Dental";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";


    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }



        return null;
    }

    @Override
    public Paciente buscar(int t) {
        return null;
    }


}
