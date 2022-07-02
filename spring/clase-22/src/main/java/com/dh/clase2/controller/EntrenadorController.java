package com.dh.clase2.controller;

import com.dh.clase2.dominio.Entrenador;
import com.dh.clase2.service.IentrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
    private IentrenadorService ientrenadorService;

    @Autowired
    public EntrenadorController(IentrenadorService ientrenadorService){
        this.ientrenadorService = ientrenadorService;
    }
    @GetMapping
    public List<Entrenador> obtenerListadoEntrenador(){
        return ientrenadorService.listaEntrenador();
    }

}
