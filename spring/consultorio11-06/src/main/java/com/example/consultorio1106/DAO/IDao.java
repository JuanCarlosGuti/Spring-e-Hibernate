package com.example.consultorio1106.DAO;

import java.util.List;

public interface IDao<T> {

    T buscarXCriterio(String criterio);
    T actualizar (T t);
    T guardar(T t);
    T buscar(int id);

    void eliminar(int id);
    List<T> buscarTodos();
}
