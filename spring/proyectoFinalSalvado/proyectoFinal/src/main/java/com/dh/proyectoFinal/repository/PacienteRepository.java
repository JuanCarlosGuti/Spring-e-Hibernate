package com.dh.proyectoFinal.repository;

import com.dh.proyectoFinal.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
