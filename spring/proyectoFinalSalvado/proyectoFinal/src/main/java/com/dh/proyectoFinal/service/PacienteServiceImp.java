package com.dh.proyectoFinal.service;


import com.dh.proyectoFinal.entity.Paciente;
import com.dh.proyectoFinal.exceptions.NoEncontradoIdException;
import com.dh.proyectoFinal.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImp implements IpacienteService {


    private static final Logger logger = Logger.getLogger(PacienteServiceImp.class);

    PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImp(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listarPacientes() {

        return pacienteRepository.findAll();

    }

    @Override
    public Paciente buscarXId(Integer id) {
        Paciente paciente=null;
        Optional<Paciente> optionaPaciente= pacienteRepository.findById(id);
        if (optionaPaciente.isPresent()){
            paciente= optionaPaciente.get();
            logger.info(" el id esta presente en la base de datos");

        }
        return paciente;
    }

    @Override
    public Paciente guardarPaciente(Paciente p) {
        logger.info(" el paciente se creo correctamente");
        return pacienteRepository.save(p);

    }

    @Override
    public Paciente actualizarPaciente(Paciente p) throws NoEncontradoIdException {
        if (buscarXId(p.getId())==null)
            throw new NoEncontradoIdException("No encontramos un pacinete con el id "+p.getId());
        return pacienteRepository.save(p);
    }

    @Override
    public void eliminarPaciente(Integer id) throws NoEncontradoIdException {
        if (buscarXId(id)==null)
            throw new NoEncontradoIdException("No encontramos un pacinete con el id "+id);
        pacienteRepository.deleteById(id);

    }


}
