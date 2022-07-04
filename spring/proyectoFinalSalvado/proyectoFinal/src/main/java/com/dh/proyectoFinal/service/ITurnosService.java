package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Turno;
import com.dh.proyectoFinal.exceptions.NoEncontradoIdException;

import java.util.List;

public interface ITurnosService {
    List<Turno> listadoTurnos();
    Turno registrarTurno(Turno t);
    Turno actualizarTurno(Turno t) throws NoEncontradoIdException;
    void eliminarTurno(int id) throws NoEncontradoIdException;
    Turno buscarTurno(int id) throws NoEncontradoIdException;



}
