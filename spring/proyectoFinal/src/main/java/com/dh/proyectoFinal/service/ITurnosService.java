package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Turno;

import java.util.List;

public interface ITurnosService {
    List<Turno> listadoTurnos();
    Object registrarTurno(Turno t);
    Turno actualizarTurno(Turno t);
    void eliminarTurno(int id);
    Turno buscarTurno(int id);



}
