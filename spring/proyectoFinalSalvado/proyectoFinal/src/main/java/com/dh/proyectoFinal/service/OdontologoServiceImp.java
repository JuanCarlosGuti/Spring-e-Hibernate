package com.dh.proyectoFinal.service;


import com.dh.proyectoFinal.entity.Odontologo;
import com.dh.proyectoFinal.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImp implements IOdontologoService {
    IOdontologoRepository iOdontologoRepository;

    @Autowired
    public OdontologoServiceImp(IOdontologoRepository iOdontologoRepository) {
        this.iOdontologoRepository = iOdontologoRepository;
    }




    @Override
    public List<Odontologo> listarOdontologos() {
        return iOdontologoRepository.findAll();
    }

    @Override
    public Odontologo buscarXId(int id) {
        Odontologo odontologo=null;
        Optional<Odontologo> optionOdontologo= iOdontologoRepository.findById(id);
        if (optionOdontologo.isPresent()){
            odontologo= optionOdontologo.get();
        }
        return odontologo;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        return iOdontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        return iOdontologoRepository.save(odontologo);

    }

    @Override
    public void eliminarOdontologo(int id) {
        iOdontologoRepository.deleteById(id);

    }
}
