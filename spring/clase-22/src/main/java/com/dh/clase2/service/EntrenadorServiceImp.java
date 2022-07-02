package com.dh.clase2.service;

import com.dh.clase2.DAO.EntrenadoDAOH2;
import com.dh.clase2.DAO.IDAO;
import com.dh.clase2.dominio.Entrenador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImp implements IentrenadorService{
    @Override
    public List<Entrenador> listaEntrenador() {
        IDAO<Entrenador> dao = new EntrenadoDAOH2();

        return dao.listarTodos();
    }
}
