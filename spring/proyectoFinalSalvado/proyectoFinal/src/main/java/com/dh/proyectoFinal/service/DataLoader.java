package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Usuario;
import com.dh.proyectoFinal.entity.UsuarioRol;
import com.dh.proyectoFinal.repository.UsuarioRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Encriptar contraseña
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("123");
        String password2 = encoder.encode("pass6123");

        Usuario usuario = new Usuario("Admin","admin","adminfny@digital.com",password, UsuarioRol.ADMIN);
        Usuario usuario2 = new Usuario("User","user","adminfny@digital.com",password2, UsuarioRol.USER);
        this.usuarioRepository.save(usuario);
        this.usuarioRepository.save(usuario2);

    }
}
