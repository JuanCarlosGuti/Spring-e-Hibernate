package com.DAO;

import com.Conexion;
import com.entidades.Odontologo;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDAOH2 implements IDAO<Odontologo>{

   private final static String SQL_CREATE= "CREATE TABLE IF NOT EXISTS ODONTOLOGOS " +
            "(id int auto_increment primary key,numeroMatricula int,nombre varchar(255),apellido varchar(255));";

    Logger logger = Logger.getLogger(OdontologoDAOH2.class);


    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Conexion coneccion = new Conexion();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = coneccion.conectarConBaseDeDatos();
            logger.info("Se ha establecido la conexión");

            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS(numeroMatricula,nombre,apellido) VALUES(?,?,?)");
            preparedStatement.setInt(1,odontologo.getNumeroMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());

            preparedStatement.execute();
            preparedStatement.close();
            logger.info("Se han insertado los valores correspondientes ");

        }  catch (SQLException e) {
            logger.error("ha ocurrido algun error al crear la tabla o al insertar el dato");
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Odontologo> listar() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    List<Odontologo> listaOdontlogos = new ArrayList<>();
    logger.info("Se ha creada la lista ");

        try {
            Conexion conexion = new Conexion();
            connection = conexion.conectarConBaseDeDatos();
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS;");

            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
            listaOdontlogos.add(new Odontologo(rs.getLong(1), rs.getInt(2),rs.getString(3),rs.getString(4) ));

            }
            logger.info("se generado la lista con sus elementos");
            preparedStatement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaOdontlogos;
    }
}
