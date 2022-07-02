package com.dh.clase31S.services;

import com.dh.clase31S.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    String registrarUsuario(Usuario usuario);
}
