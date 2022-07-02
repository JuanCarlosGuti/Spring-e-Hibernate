package com.dh.clase31.service;

import com.dh.clase31.entities.Movimiento;
import com.dh.clase31.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServiceImpl implements IMovimientoService{
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public List<Movimiento> listarMovimientos() {
        return movimientoRepository.findAll();
    }

    @Override
    public String guardarMovimiento(Movimiento movimiento) {
        if (movimientoRepository.save(movimiento)!=null){
            return "Se guardó el movimiento sin problemas";
        }
        else{
            return "Error al momento de guardar";
        }

    }
}
