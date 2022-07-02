package com.dh.proyectoFinal.repository;

import com.dh.proyectoFinal.entity.Turno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoDAO implements IDao<Turno> {

    private  List<Turno> turnos;
    public TurnoDAO(){
        turnos = new ArrayList<>();
    }

    @Override
    public List<Turno> listarElementos() {
        return turnos;
    }

    @Override
    public Turno buscarXCriterio(String criterio) {

        return null;
    }

    @Override
    public Turno buscarXId(int id) {
        Turno t = null;
        for(Turno turno:turnos){
            if (turno.getId()==id){
                t = turno;
            }

        }
        return t;
    }

    @Override
    public void eliminar(int id) {
        Turno turnoBuscado = buscarXId(id);
        turnos.remove(turnoBuscado);


    }

    @Override
    public Turno actualizar(Turno turno) {
//        Turno turno1  =  buscarXId(turno.getId());
//        int indiceTurnoanterior = turnos.indexOf(turno1);
//        turnos.set(indiceTurnoanterior,turno);
//        return turno;
        eliminar(turno.getId());
        return guardar(turno);


    }

    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);


        return turno;

    }
}
