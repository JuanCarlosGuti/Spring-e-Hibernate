package com.service;

import com.dao.IDao;
import com.entidades.Odontologo;
import com.entidades.Paciente;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }



    public Odontologo buscarOdontologo(int id){
        return odontologoIDao.buscar(id);
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public void eliminarOdontologo(int id){
        odontologoIDao.eliminar(id);
    }
    public List<Odontologo> buscarTodosOdontologo(){
        return odontologoIDao.buscarTodos();
    }
}
