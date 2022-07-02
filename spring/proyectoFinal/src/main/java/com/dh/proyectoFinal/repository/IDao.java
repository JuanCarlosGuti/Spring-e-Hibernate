package com.dh.proyectoFinal.repository;

import java.util.List;

public interface IDao <T>{

    List<T> listarElementos();
    T buscarXCriterio(String criterio);
    T buscarXId(int id);
    void eliminar(int id);
    T actualizar (T t);
    T guardar (T t);
}
