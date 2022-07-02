package com.company.entidades;

import com.company.dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoH2 implements IDao<Estudiantes> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/bd_estuduantes";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";


    @Override
    public Estudiantes guardar(Estudiantes estudiantes) {
        Connection connection = null;
        PreparedStatement preparedStatement= null;



        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO estudiantes VALUES(?,?,?)");
            preparedStatement.setLong(1,estudiantes.getId());
            preparedStatement.setString(2, estudiantes.getNombre());
            preparedStatement.setString(3,estudiantes.getApellido());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return estudiantes;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement= null;



        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes WHERE id=?");
            preparedStatement.setLong(1,id);


            preparedStatement.execute();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public Estudiantes buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        Estudiantes estudiantes = null;



        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes where id=?");
            preparedStatement.setLong(1,id);


            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Long idEstuadiante = resultSet.getLong("id");
                String nombreEstudiantes = resultSet.getString("nombre");
                String apellidoEstudiante = resultSet.getString("apellido");
                estudiantes = new Estudiantes();
                estudiantes.setApellido(apellidoEstudiante);
                estudiantes.setNombre(nombreEstudiantes);
                estudiantes.setId(idEstuadiante);


            }



            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estudiantes;

    }

    @Override
    public List<Estudiantes> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        List<Estudiantes> estudiantess  = new ArrayList();



        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes");



            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Long idEstuadiante = resultSet.getLong("id");
                String nombreEstudiantes = resultSet.getString("nombre");
                String apellidoEstudiante = resultSet.getString("apellido");
                Estudiantes estudiantes = new Estudiantes();
                estudiantes.setApellido(apellidoEstudiante);
                estudiantes.setNombre(nombreEstudiantes);
                estudiantes.setId(idEstuadiante);
                estudiantess.add(estudiantes);


            }



            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estudiantess;
    }
}
