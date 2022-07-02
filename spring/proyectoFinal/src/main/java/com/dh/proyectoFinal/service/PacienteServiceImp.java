package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.repository.IDao;
import com.dh.proyectoFinal.repository.PacienteDAO;
import com.dh.proyectoFinal.entity.Paciente;
import com.dh.proyectoFinal.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class PacienteServiceImp implements IpacienteService {


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
        return pacienteRepository.findById(id).get();
    }

    @Override
    public Paciente guardarPaciente(Paciente p) {

        return pacienteRepository.save(p);
    }

    @Override
    public Paciente actualizarPaciente(Paciente p) {
        return pacienteRepository.save(p);
    }

    @Override
    public void eliminarPaciente(Integer id) {
        pacienteRepository.deleteById(id);

    }


}
