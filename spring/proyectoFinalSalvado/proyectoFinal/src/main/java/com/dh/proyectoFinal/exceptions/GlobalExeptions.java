package com.dh.proyectoFinal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptions {
    @ExceptionHandler({NoEncontradoIdException.class})
    public ResponseEntity<String> procesarErrorNotFound(NoEncontradoIdException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()+" Desde Global");

    }
}
