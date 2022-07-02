package com.example.consultorio1106.DAO;


import com.example.consultorio1106.dominio.Domicilio;
import com.example.consultorio1106.dominio.Paciente;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente>{
    @Override
    public Paciente buscarXCriterio(String criterio) {
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio = null;
        try{
            connection=Conexion.getConnection();
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM " +
                    "PACIENTES WHERE EMAIL=?");
            ps.setString(1,criterio);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                //cargar la información de la BD en un objeto de la clase Paciente
                DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();

                paciente=new Paciente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        domicilioDAOH2.buscar(rs.getInt(7)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return paciente;


    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection=null;

        try{
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            domicilioDAOH2.guardar(paciente.getDomicilio());
            connection= Conexion.getConnection();
            PreparedStatement ps=connection.prepareStatement("INSERT INTO PACIENTES " +
                    "(NOMBRE, APELLIDO, EMAIL, DNI, FECHA, DOMICILIO_ID) VALUES (?,?,?,?,?,?)");
            ps.setString(1,paciente.getNombre());
            ps.setString(2,paciente.getApellido());
            ps.setString(3,paciente.getEmail());
            ps.setInt(4, paciente.getDni());
            ps.setDate(5,Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(6,paciente.getDomicilio().getId());
            ps.execute();

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public Paciente buscar(int id) {
        Connection connection=null;
        Paciente paciente=null;
        try{
            connection=Conexion.getConnection();
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM " +
                    "PACIENTES WHERE ID=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                //cargar la información de la BD en un objeto de la clase Paciente
                DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
                paciente=new Paciente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        domicilioDAOH2.buscar(rs.getInt(5)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return paciente;
    }
    @Override
    public void eliminar(int id) {
        Connection connection=null;
        try{
            Paciente pacienteBuscado=buscar(id);
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            domicilioDAOH2.eliminar(pacienteBuscado.getDomicilio().getId());
            connection=Conexion.getConnection();
            PreparedStatement ps= connection.prepareStatement("DELETE FROM PACIENTES " +
                    "WHERE ID=?");
            ps.setInt(1,id);
            ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection=null;
        ArrayList<Paciente> pacientes=new ArrayList<>();
        try{
            connection=Conexion.getConnection();
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM PACIENTES");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
                pacientes.add(new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getDate(4).toLocalDate(),
                        domicilioDAOH2.buscar(rs.getInt(5))));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return pacientes;
    }


}
