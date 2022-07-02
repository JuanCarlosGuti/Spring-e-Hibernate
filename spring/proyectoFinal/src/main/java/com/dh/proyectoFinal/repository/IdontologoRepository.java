package com.dh.proyectoFinal.repository;

import com.dh.proyectoFinal.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdontologoRepository extends JpaRepository<Odontologo,Integer> {
}
