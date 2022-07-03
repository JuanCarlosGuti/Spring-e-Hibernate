package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Turno;
import com.dh.proyectoFinal.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnosService {
    List<Turno> listadoTurnos();
    Turno registrarTurno(Turno t);
    Turno actualizarTurno(Turno t) throws ResourceNotFoundException;
    void eliminarTurno(int id) throws ResourceNotFoundException;
    Turno buscarTurno(int id);



}
