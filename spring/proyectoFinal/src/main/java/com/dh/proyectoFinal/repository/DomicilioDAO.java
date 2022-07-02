package com.dh.proyectoFinal.repository;

import com.dh.proyectoFinal.entity.Domicilio;

import java.sql.*;
import java.util.List;

public class DomicilioDAO implements IDao<Domicilio> {
    @Override
    public List<Domicilio> listarElementos() {
        return null;

    }

    @Override
    public Domicilio buscarXCriterio(String criterio) {
        return null;
    }

    @Override
    public Domicilio buscarXId(int id) {
        Connection connection = null;
        Domicilio domicilio = null;
        connection = Conexion.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM" +
                    " DOMICILIOS WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return domicilio;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        connection = Conexion.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM DOMICILIOS WHERE ID = ?");
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        Connection connection = null;
        connection = Conexion.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("" +
                    "UPDATE DOMICILIOS SET CALLE=?, NUMERO=?, " +
                            "LOCALIDAD=?, PROVINCIA=? WHERE ID=? ");
            ps.setString(1,domicilio.getCalle());
            ps.setInt(2,domicilio.getNumero());
            ps.setString(3,domicilio.getLocalidad());
            ps.setString(4,domicilio.getProvincia());
            ps.setInt(5,domicilio.getId());
            ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;

        connection = Conexion.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO DOMICILIOS (CALLE, NUMERO, " +
                            "LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                domicilio.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return domicilio;
    }
}