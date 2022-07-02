package com.dh.proyectoFinal.service;

import com.dh.proyectoFinal.entity.Domicilio;
import com.dh.proyectoFinal.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DomicilioServiceImp implements IDomicioService{

    private DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioServiceImp(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> listarDomicilios() {
        return domicilioRepository.findAll();
    }

    @Override
    public Domicilio buscarDomiXId(int id) {
        return domicilioRepository.findById(id).get();
    }

    @Override
    public Domicilio guardarDomicilio(Domicilio d) {
        return domicilioRepository.save(d);
    }

    @Override
    public Domicilio actualizarDomicilio(Domicilio d) {
        return domicilioRepository.save(d);
    }

    @Override
    public void eliminarDomicilio(int id) {
        domicilioRepository.deleteById(id);

    }
}
