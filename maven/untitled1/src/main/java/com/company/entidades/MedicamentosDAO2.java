package com.company.entidades;

import com.company.dao.IDao;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class MedicamentosDAO2 implements IDao<Medicamento> {

    private static final Logger logger = Logger.getLogger(Medicamento.class);


    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/bd_medicamentos";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        logger.info(" se esta guardando el medicamento: "+medicamento);

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            logger.info("estableciendo conexión");

            preparedStatement = connection.prepareStatement("INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)");
            preparedStatement.setInt(1,medicamento.getCod());
            preparedStatement.setString(2,medicamento.getNombre());
            preparedStatement.setString(3,medicamento.getLaboratorio());
            preparedStatement.setInt(4,medicamento.getCantidad());
            preparedStatement.setDouble(5,medicamento.getPrecio());
            preparedStatement.setLong(6,medicamento.getId());

            preparedStatement.execute();
            preparedStatement.close();
            logger.info("insertando los valores en medicamento:"+medicamento.getNombre());

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return medicamento;


    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM MEDICAMENTOS WHERE ID=?");

            preparedStatement.setLong(1,id);

            preparedStatement.execute();
            preparedStatement.close();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public Medicamento buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamento = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID=?");

            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int codigo = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String laboratorio = resultSet.getString(3);
                int cantidad = resultSet.getInt(4);
                double precio = resultSet.getDouble(5);
                Long idMedicamento = resultSet.getLong(6);
                medicamento = new Medicamento(codigo,nombre,laboratorio,cantidad,precio,idMedicamento);





            }


            preparedStatement.close();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return medicamento;
    }

    @Override
    public List<Medicamento> buscarTodos() {
        return null;
    }
}
