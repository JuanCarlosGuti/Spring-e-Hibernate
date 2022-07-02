package com;

import com.dao.OdontologoDAOH2;

import com.entidades.Odontologo;

import com.service.OdontologoService;
import com.util.Conexion;


public class Main {

    public static void main(String[] args) {

        Odontologo odontologo = new Odontologo(5,"juan","gutierrez");
        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

        odontologoService.guardarOdontologo(odontologo);




    }
}
