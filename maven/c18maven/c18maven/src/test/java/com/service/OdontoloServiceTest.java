package com.service;

import com.DAO.OdontologoDAOH2;
import com.entidades.Odontologo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontoloServiceTest {
    @Test
    public void listarOdontologosTest(){
        OdontoloService odontoloService = new OdontoloService(new OdontologoDAOH2());

        List<Odontologo> odontologos = odontoloService.listarOdontologos();
        for (Odontologo od:odontologos){
            System.out.println(od.getNombre());
        }

        Assert.assertTrue(odontologos.size()>0);


    }


}