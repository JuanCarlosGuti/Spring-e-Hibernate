package com.dh.proyectoFinal.controller;

import com.dh.proyectoFinal.repository.OdontologoDAO;
import com.dh.proyectoFinal.repository.TurnoDAO;
import com.dh.proyectoFinal.entity.Odontologo;
import com.dh.proyectoFinal.entity.Paciente;
import com.dh.proyectoFinal.entity.Turno;
import com.dh.proyectoFinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnosService turnosService;
    @Autowired
    private IpacienteService ipacienteService;
    @Autowired
    private IOdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<Turno>> listandoTurnos(){
       return ResponseEntity.ok(turnosService.listadoTurnos());
    }

    @PostMapping
        public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
           /* ResponseEntity<Turno> respuesta;
            Paciente pacienteBuscado = ipacienteService.buscarXId(turno.getPaciente().getId());
            Odontologo odontologoBuscado = odontologoService.buscarXId(turno.getOdontologo().getId());
            if (pacienteBuscado!=null&&odontologoBuscado!=null){
               respuesta= ResponseEntity.ok(turnosService.registrarTurno(turno));
            }else {
                respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }*/
            return null;
        }
    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
        ResponseEntity<Turno> response;
        if(pacienteService.buscar(turno.getPaciente().getId()) != null && odontologoService.buscar(turno.getOdontologo().getId()) != null){
            response = ResponseEntity.ok(turnoService.registrarTurno(turno));
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }


       /* @GetMapping
        public Turno buscarTurnoXid(@PathVariable int id){
            return turnosService.buscarTurno(id);
        }*/


        @DeleteMapping("/{id}")
        public ResponseEntity<String> elimanrTurno(@PathVariable int id){
            if(turnosService.buscarTurno(id) != null){
                turnosService.eliminarTurno(id);
             return    ResponseEntity.ok("Se eleimino el turno: "+ id +"  correctamente");
            }else {
             return     ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No se elimino el turno con id: "+id+" por" +
                        " que el turno no se encontro");
            }
        }

        @PutMapping
        public ResponseEntity<Turno> actualTurno(@RequestBody Turno turno){
            if (turnosService.buscarTurno(turno.getId())!=null){
                return ResponseEntity.ok(turnosService.actualizarTurno(turno));
            }else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }

