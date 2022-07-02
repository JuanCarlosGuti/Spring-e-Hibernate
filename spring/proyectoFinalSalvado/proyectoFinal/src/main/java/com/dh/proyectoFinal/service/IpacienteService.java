package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Paciente;

import java.util.List;

public interface IpacienteService {
    List<Paciente> listarPacientes();


    Paciente buscarXId(Integer id);
    Paciente guardarPaciente(Paciente p);
    Paciente actualizarPaciente(Paciente p);

    void eliminarPaciente(Integer id);

}
