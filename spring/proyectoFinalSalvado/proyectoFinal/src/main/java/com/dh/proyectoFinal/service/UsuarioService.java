package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Usuario;
import com.dh.proyectoFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado=usuarioRepository.findByEmail(email);
        if (usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }
        else{
            throw new UsernameNotFoundException("el email no es corresto");

        }
    }
}
