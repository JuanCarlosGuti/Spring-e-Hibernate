package com.dh.proyectoFinal.controller;
import com.dh.proyectoFinal.entity.Turno;
import com.dh.proyectoFinal.exceptions.BadRequestException;
import com.dh.proyectoFinal.exceptions.NoEncontradoIdException;
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
        public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
            ResponseEntity<Turno> response;
            if(ipacienteService.buscarXId(turno.getPaciente().getId()) != null && odontologoService.buscarXId(turno.getOdontologo().getId()) != null){
                response = ResponseEntity.ok(turnosService.registrarTurno(turno));
            }else{
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return response;
        }


        @GetMapping("/{id}")
        public Turno buscarTurnoXid(@PathVariable int id) throws NoEncontradoIdException {
            return turnosService.buscarTurno(id);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity elimanrTurno(@PathVariable int id) throws NoEncontradoIdException {
            turnosService.eliminarTurno(id);
            return ResponseEntity.ok("turno eliminado");
        }

        @PutMapping
        public Turno actualTurno(@RequestBody Turno turno) throws NoEncontradoIdException {
              return turnosService.actualizarTurno(turno);
        }

      /*  @ExceptionHandler({ResourceNotFoundException.class})
        public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

        }*/
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    }

