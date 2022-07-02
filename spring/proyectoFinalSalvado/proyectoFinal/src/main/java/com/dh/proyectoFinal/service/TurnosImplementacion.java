package com.dh.proyectoFinal.service;


import com.dh.proyectoFinal.entity.Turno;
import com.dh.proyectoFinal.exceptions.ResourceNotFoundException;
import com.dh.proyectoFinal.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnosImplementacion implements ITurnosService{

    ITurnoRepository iTurnoRepository;

    @Autowired
    public TurnosImplementacion(ITurnoRepository iTurnoRepository) {
        this.iTurnoRepository = iTurnoRepository;
    }

    @Override
    public List<Turno> listadoTurnos() {
        return iTurnoRepository.findAll();
    }

    @Override
    public Turno registrarTurno(Turno t) {
        return iTurnoRepository.save(t);
    }

    @Override
    public Turno actualizarTurno(Turno t) {
        return iTurnoRepository.save(t);

    }

    @Override
    public void eliminarTurno(int id) throws ResourceNotFoundException {
        if (buscarTurno(id)==null)
             throw new ResourceNotFoundException("no existe un turno con ese ID");
        iTurnoRepository.deleteById(id);
    }


    @Override
    public Turno buscarTurno(int id) {
        Turno turno=null;
        Optional<Turno> optionaPaciente= iTurnoRepository.findById(id);
        if (optionaPaciente.isPresent()){
            turno= optionaPaciente.get();
        }
        return turno;
    }
}
