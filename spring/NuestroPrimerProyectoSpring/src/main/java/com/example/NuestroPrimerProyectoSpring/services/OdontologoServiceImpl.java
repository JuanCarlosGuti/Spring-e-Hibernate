package com.example.NuestroPrimerProyectoSpring.services;

import com.example.NuestroPrimerProyectoSpring.dominio.Odontologo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service

public class OdontologoServiceImpl  implements OdontologoService{

    @Override
    public List<Odontologo> listadoOdontologos() {
        return Arrays.asList(new Odontologo("Juan"),new Odontologo("Mario"),new Odontologo("MAria"),
                new Odontologo("Josefa"));



    }
}
