package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Domicilio;
import com.dh.proyectoFinal.entity.Paciente;

import java.util.List;

public interface IDomicioService {

    List<Domicilio> listarDomicilios();
    Domicilio buscarDomiXId(int id);
    Domicilio guardarDomicilio(Domicilio d);
    Domicilio actualizarDomicilio(Domicilio d);

    void eliminarDomicilio(int id);
}
