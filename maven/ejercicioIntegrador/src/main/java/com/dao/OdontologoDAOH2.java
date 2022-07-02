package com.dao;


import com.entidades.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDAOH2 implements IDao<Odontologo>{


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return null;
    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        return null;
    }
}
