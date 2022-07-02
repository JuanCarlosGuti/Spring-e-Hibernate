package com.util;

import java.sql.*;

public class Conxion {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/bd_Clinica_Dental";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";
    private final static String SQL_CREATE= "CREATE TABLE IF NOT EXISTS ODONTOLOGOS " +
            "(id int auto_increment primary key,numeroMatricula int,nombre varchar(255),apellido varchar(255));";
    private static Connection connection;

    public static Connection getInstance(){
        if (connection==null){
            try {
                Class.forName(DB_JDBC_DRIVER);
                connection =  DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return connection;
    }







}
