package com.dh.clase31S.controllers;

import com.dh.clase31S.entities.Usuario;
import com.dh.clase31S.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        if(usuarioService.listarUsuarios().size() > 0) {
            return ResponseEntity.ok(usuarioService.listarUsuarios());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public  ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
        String res = usuarioService.registrarUsuario(usuario);
        if(res.equals("Se guardó el usuario sin problemas")){
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }
    }
}
