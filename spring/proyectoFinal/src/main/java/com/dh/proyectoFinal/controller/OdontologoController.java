package com.dh.proyectoFinal.controller;


import com.dh.proyectoFinal.entity.Odontologo;
import com.dh.proyectoFinal.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private IOdontologoService odontologoService;

    @Autowired
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologoXId(@PathVariable int id ){
        return odontologoService.buscarXId(id);
    }

    @PostMapping
    public ResponseEntity<Odontologo> agregarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.registrar(odontologo));
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarOdontologos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }
    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        if (odontologoService.buscarXId(odontologo.getId())!=null){
            return ResponseEntity.ok(odontologoService.modificar(odontologo));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable int id){
        if (odontologoService.buscarXId(id)!=null){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó el odontólogo con id="+id);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo" +
                    "eliminar al odontólogo con id="+id+" al no ser encontrado");
        }
    }
    /*
    @GetMapping
    public String traerOdontologoXId(Model model, @RequestParam("id") int id){
        Odontologo odontologo=odontologoService.buscarXId(id);
        model.addAttribute("matricula",odontologo.getMatricula());
        return "odontologo";
    }

     */
}
