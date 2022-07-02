package com.dh.proyectoFinal.controller;

import com.dh.proyectoFinal.entity.Paciente;
import com.dh.proyectoFinal.service.PacienteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteServiceImp pacienteService;


    @Autowired
    public PacienteController(PacienteServiceImp pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/lista")
    public List<Paciente> traerPacientes(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public Paciente traePacinetXId(@PathVariable("id") Integer id){
        return pacienteService.buscarXId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
       pacienteService.eliminarPaciente(id);

    }

    @PostMapping
    public Paciente registrarNuevoPaciente(@RequestBody Paciente p){
       return pacienteService.guardarPaciente(p);
    }

    @PutMapping
    public Paciente modificarCliente(@RequestBody Paciente p){
        return pacienteService.actualizarPaciente(p);
    }


}
