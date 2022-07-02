package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    List<Odontologo> listarOdontologos();
    Odontologo buscarXId(int id);

    Odontologo registrar(Odontologo odontologo);

    Odontologo modificar(Odontologo odontologo);

    void eliminarOdontologo(int id);





}
