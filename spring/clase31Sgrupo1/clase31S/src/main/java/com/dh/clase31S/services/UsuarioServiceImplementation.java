package com.dh.clase31S.services;

import com.dh.clase31S.entities.Usuario;
import com.dh.clase31S.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplementation implements IUsuarioService{
    @Autowired private IUsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public String registrarUsuario(Usuario usuario) {
        if (usuarioRepository.save(usuario)!=null){
            return "Se guardó el usuario sin problemas";
        }
        else{
            return "Error al momento de guardar";
        }
    }
}
