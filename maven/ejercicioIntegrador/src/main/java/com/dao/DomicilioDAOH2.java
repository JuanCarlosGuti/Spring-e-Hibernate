package com.dao;

import com.entidades.Domicilio;

import java.sql.*;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio>{
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection=null;

        try{
            connection=getConnection();
            PreparedStatement ps= connection.prepareStatement("INSERT INTO DOMICILIOS " +
                    "(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //CARGAR LOS 4 VALORES
            ps.setString(1,domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3,domicilio.getLocalidad());
            ps.setString(4,domicilio.getProvincia());
            ps.execute();
            ResultSet key=ps.getGeneratedKeys();
            while(key.next()){
                domicilio.setId(key.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return domicilio;
    }

    @Override
    public Domicilio buscar(int id) {
        Connection connection=null;
        Domicilio domicilio=null;
        try{
            connection=getConnection();
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM " +
                    "DOMICILIOS WHERE ID=?");
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                domicilio= new Domicilio(rs.getInt(1),
                        rs.getString(2),rs.getInt(3),
                        rs.getString(4),rs.getString(5));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }
    public void eliminar(int id) {
        Connection connection=null;
        try{
            connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("DELETE FROM " +
                    "DOMICILIOS WHERE ID=?");
            ps.setInt(1,id);
            ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return null;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/bd_Clinica_Dental","root","");
    }
}
