package com.example.consultorio1106.DAO;



import com.example.consultorio1106.dominio.Odontologo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OdontologoDAOH2 implements IDao<Odontologo>{


    @Override
    public Odontologo buscarXCriterio(String criterio) {
        return null;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexion.getConnection();

            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS(numeroMatricula,nombre,apellido) VALUES(?,?,?)");
            preparedStatement.setInt(1,odontologo.getNumeroMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());

            preparedStatement.execute();
            preparedStatement.close();

        }  catch (SQLException e) {

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
