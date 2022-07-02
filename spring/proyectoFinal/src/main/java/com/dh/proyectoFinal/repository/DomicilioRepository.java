package com.dh.proyectoFinal.repository;

import com.dh.proyectoFinal.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Integer> {

}
