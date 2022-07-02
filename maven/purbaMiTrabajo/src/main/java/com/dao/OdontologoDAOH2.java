package com.dao;


import com.entidades.Odontologo;
import com.entidades.Paciente;
import com.util.Conexion;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;


public class OdontologoDAOH2 implements IDao<Odontologo>{
    Logger logger = Logger.getLogger(OdontologoDAOH2.class);


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexion.getConnection();
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


        return odontologo;

    }

    @Override
    public Odontologo buscar(int id) {
        Connection connection = null;
        Odontologo odontologo = null;

        connection = Conexion.getConnection();

        try {
            PreparedStatement  ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return odontologo;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        return null;
    }
}
