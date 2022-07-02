package com.service;

import com.dao.IDao;
import com.model.Paciente;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;
    public PacienteService(IDao<Paciente> pacienteDao){
        pacienteIDao = pacienteDao;
    }
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }
    public Paciente buscarPaciente(int id){
        return pacienteIDao.buscar(id);
    }

}
