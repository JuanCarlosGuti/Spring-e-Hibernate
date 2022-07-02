package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/bd_Clinica_Dental;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";

    private final static String DBURL = "jdbc:h2:~/bd_Clinica_Dental";


    private static Connection connection;

    public static Connection crearTablas(){
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




    public static Connection getConnection(){
        if (connection==null){
            try {
                Class.forName(DB_JDBC_DRIVER);
                connection =  DriverManager.getConnection(DBURL,DB_USER,DB_PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return connection;
    }







}
