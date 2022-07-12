package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Paciente;
import com.dh.proyectoFinal.exceptions.NoEncontradoIdException;
import org.apache.log4j.Logger;

import java.util.List;

public interface IpacienteService {



    List<Paciente> listarPacientes();


    Paciente buscarXId(Integer id);
    Paciente guardarPaciente(Paciente p);
    Paciente actualizarPaciente(Paciente p) throws NoEncontradoIdException;

    void eliminarPaciente(Integer id) throws NoEncontradoIdException;

}
