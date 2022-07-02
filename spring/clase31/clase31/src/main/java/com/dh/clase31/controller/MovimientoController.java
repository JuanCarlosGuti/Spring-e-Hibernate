package com.dh.clase31.controller;

import com.dh.clase31.entities.Movimiento;
import com.dh.clase31.service.IMovimientoService;
import com.dh.clase31.service.MovimientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoServiceImpl service;

    @PostMapping
    public ResponseEntity<String> guardarMovimiento(@RequestBody Movimiento movimiento){
        return ResponseEntity.ok(service.guardarMovimiento(movimiento));
    }
    @GetMapping
    public ResponseEntity<List<Movimiento>> listarTodosLosMovimientos(){
        return ResponseEntity.ok(service.listarMovimientos());
    }

}
