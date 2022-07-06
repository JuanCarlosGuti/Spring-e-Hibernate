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

    //para agregar usuarios en la base de datos...
    private UsuarioRepository iUsuarioRepository;

    public DataLoader(UsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //encriptar la contraseña

        BCryptPasswordEncoder passwordEndoder1 = new BCryptPasswordEncoder();
        String password1 = passwordEndoder1.encode("pass1");
        BCryptPasswordEncoder passwordEndoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEndoder2.encode("pass2");

        //crear usuarios:
        Usuario usuario1 = new Usuario("Administrador5", "administrador5", "administrador5@admin.com", password1, UsuarioRol.ADMIN);
        Usuario usuario2 = new Usuario("Usuario5", "usuario5", "usuario5@user.com", password2, UsuarioRol.USER);
        this.iUsuarioRepository.save(usuario1);
        this.iUsuarioRepository.save(usuario2);

    }
}
