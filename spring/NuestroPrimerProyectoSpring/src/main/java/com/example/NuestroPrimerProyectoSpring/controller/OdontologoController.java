package com.example.NuestroPrimerProyectoSpring.controller;


import com.example.NuestroPrimerProyectoSpring.dominio.Odontologo;
import com.example.NuestroPrimerProyectoSpring.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> getOdontologo(){
        return odontologoService.listadoOdontologos();
    }

}
