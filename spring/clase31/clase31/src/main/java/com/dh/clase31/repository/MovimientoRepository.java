package com.dh.clase31.repository;

import com.dh.clase31.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
}
