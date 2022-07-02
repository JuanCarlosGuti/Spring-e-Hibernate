package com.dh.clase2.DAO;

import com.dh.clase2.dominio.Entrenador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntrenadoDAOH2 implements IDAO<Entrenador>{
    @Override
    public List<Entrenador> listarTodos() {
        Connection connection = null;
        List<Entrenador> listarEntrenador = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ENTRENADORES");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listarEntrenador.add(new Entrenador(rs.getInt(1),
                        rs.getString(2)));
            }


        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return listarEntrenador;
    }
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/ejemplotreceJunio" ,"root","");
    }
}
