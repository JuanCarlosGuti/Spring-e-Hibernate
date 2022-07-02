package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.repository.IDao;
import com.dh.proyectoFinal.entity.Odontologo;
import com.dh.proyectoFinal.repository.IdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OdontologoServiceImp implements IOdontologoService {

    IdontologoRepository idontologoRepository;

    public OdontologoServiceImp(IdontologoRepository idontologoRepository) {
        this.idontologoRepository = idontologoRepository;
    }

    @Autowired


    @Override
    public List<Odontologo> listarOdontologos() {
        return idontologoRepository.findAll();
    }

    @Override
    public Odontologo buscarXId(int id) {
        return idontologoRepository.findById(id).get();
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        return idontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        return idontologoRepository.save(odontologo);

    }

    @Override
    public void eliminarOdontologo(int id) {
        idontologoRepository.deleteById(id);

    }
}
