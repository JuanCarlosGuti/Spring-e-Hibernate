package com.dh.proyectoFinal.repository;

import com.dh.proyectoFinal.entity.Paciente;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PacienteDAO implements IDao<Paciente> {
    @Override
    public List<Paciente> listarElementos() {
        Connection connection = null;
        List<Paciente> listaPacientes = new ArrayList<>();
        connection = Conexion.getConnection();
        Paciente paciente;
        try {
            DomicilioDAO domicilioDAO = new DomicilioDAO();
            PreparedStatement ps = connection.prepareStatement("SELECT *" +
                    " FROM PACIENTES");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                paciente = new Paciente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getInt(5),rs.getDate(6).toLocalDate(),
                        domicilioDAO.buscarXId(rs.getInt(7)));
                listaPacientes.add(paciente);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }

    @Override
    public Paciente buscarXCriterio(String criterio) {

        Connection connection = null;
        Paciente paciente =null;
        connection = Conexion.getConnection();

        try {
            DomicilioDAO domicilioDAO = new DomicilioDAO();
            PreparedStatement ps = connection.prepareStatement("SELECT *" +
                    " FROM PACIENTES WHERE EMAIL =?");
            ps.setString(1,criterio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                paciente = new Paciente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getInt(5),rs.getDate(6).toLocalDate(),
                        domicilioDAO.buscarXId(rs.getInt(7)));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return paciente;
    }

    @Override
    public Paciente buscarXId(int id) {


        Connection connection = null;
        Paciente paciente =null;
        connection = Conexion.getConnection();

        try {
            DomicilioDAO domicilioDAO = new DomicilioDAO();
            PreparedStatement ps = connection.prepareStatement("SELECT *" +
                    " FROM PACIENTES WHERE ID =?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                paciente = new Paciente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getInt(5),rs.getDate(6).toLocalDate(),
                        domicilioDAO.buscarXId(rs.getInt(7)));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return paciente;

    }

    @Override
    public void eliminar(int id) {

        Connection connection = null;

        connection = Conexion.getConnection();

        try {
            DomicilioDAO domicilioDAO = new DomicilioDAO();
            PreparedStatement ps = connection.prepareStatement("DELETE " +
                    " FROM PACIENTES WHERE ID =?");
            ps.setInt(1,id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }





    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;
        connection = Conexion.getConnection();
        try {
            DomicilioDAO domicilioDAO = new DomicilioDAO();
            domicilioDAO.guardar(paciente.getDomicilio());
            PreparedStatement ps = connection.prepareStatement("UPDATE" +
                    " PACIENTES  SET APELLIDO =?, NOMBRE = ?, EMAIL = ?, " +
                    "DNI = ?, FECHA_INGRESO = ?, DOMICILIO_ID = ? WHERE ID = ?");
            ps.setString(1,paciente.getApellido());
            ps.setString(2,paciente.getNombre());
            ps.setString(3,paciente.getEmail());
            ps.setInt(4,paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(6,paciente.getDomicilio().getId());
            ps.setLong(7,paciente.getId());
            ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return paciente;



    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        connection = Conexion.getConnection();
        try {
            DomicilioDAO domicilioDAO = new DomicilioDAO();
            domicilioDAO.guardar(paciente.getDomicilio());
            PreparedStatement ps = connection.prepareStatement("INSERT INTO" +
                    " PACIENTES (APELLIDO, NOMBRE, EMAIL, DNI, FECHA_INGRESO, DOMICILIO_ID)" +
                    " VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,paciente.getApellido());
            ps.setString(2,paciente.getNombre());
            ps.setString(3,paciente.getEmail());
            ps.setInt(4,paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(6,paciente.getDomicilio().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paciente;
    }
}
