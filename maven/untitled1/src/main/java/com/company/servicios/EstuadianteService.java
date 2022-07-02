package com.company.servicios;

import com.company.dao.IDao;
import com.company.entidades.Estudiantes;

import java.util.List;

public class EstuadianteService {

    private IDao<Estudiantes> estudiantesIDao;

    public IDao<Estudiantes> getEstudiantesIDao() {
        return estudiantesIDao;
    }

    public void setEstudiantesIDao(IDao<Estudiantes> estudiantesIDao) {
        this.estudiantesIDao = estudiantesIDao;
    }

    public void guardarEstudiante(Estudiantes e){
        estudiantesIDao.guardar(e);
    }

    public void eliminarEstudiante(Long id){
        estudiantesIDao.eliminar(id);
    }

    public Estudiantes buscarEstudiante(Long id){
        return estudiantesIDao.buscar(id);
    }

    public List<Estudiantes> buscarTodos(){
        return estudiantesIDao.buscarTodos();
    }
}
