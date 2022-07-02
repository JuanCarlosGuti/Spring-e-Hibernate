package com.company.entidades;

import com.company.dao.IDao;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.List;

public class Test {
    private  static IDao<Estudiantes> estudianteDao = new EstudianteDaoH2();

    @BeforeClass
    public static void cargarEstudiantes() {
        estudianteDao.guardar(new Estudiantes(1L, "EstudianteUno", "ApellidoUno"));
        estudianteDao.guardar(new Estudiantes(2L, "EstudianteDos", "ApellidoDos"));
        estudianteDao.guardar(new Estudiantes(3L, "EstudianteTres", "ApellidoTres"));
        estudianteDao.guardar(new Estudiantes(4L, "EstudianteCuatro", "ApellidoCuatro"));
    }

    @org.junit.Test
    public  void guardarYBuscarEstudiantesTest() {
        estudianteDao.guardar(new Estudiantes(5L, "Tomas", "Pereyra"));
        Estudiantes estudiante = estudianteDao.buscar(5L);
        Assert.assertNotNull(estudiante);
        Assert.assertEquals(estudiante.getNombre(), "Tomas");

    }

    @org.junit.Test
    public  void traerTodosLosEstudiantesTest() {
        List<Estudiantes> estudiantess = estudianteDao.buscarTodos();
        Assert.assertTrue(estudiantess.size() > 0);
    }

    @org.junit.Test
    public void eliminarEstudiantesTest() {
        estudianteDao.eliminar(1L);
        Assert.assertEquals(estudianteDao.buscar(1L),null);
        estudianteDao.eliminar(2L);
        Assert.assertEquals(estudianteDao.buscar(2L),null);
        estudianteDao.eliminar(3L);
        Assert.assertEquals(estudianteDao.buscar(3L),null);
        estudianteDao.eliminar(4L);
        Assert.assertEquals(estudianteDao.buscar(4L),null);
        estudianteDao.eliminar(5L);
        Assert.assertEquals(estudianteDao.buscar(5L),null);


    }

}
