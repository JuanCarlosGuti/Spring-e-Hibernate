package com.dh.proyectoFinal.repository;

import com.dh.proyectoFinal.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
