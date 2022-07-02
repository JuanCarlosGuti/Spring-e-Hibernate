package com.dh.clase31.service;

import com.dh.clase31.entities.Movimiento;

import java.util.List;

public interface IMovimientoService {
    List<Movimiento> listarMovimientos();
    String guardarMovimiento(Movimiento movimiento);
}
