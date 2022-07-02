package com.dh.proyectoFinal;

import com.dh.proyectoFinal.entity.Domicilio;
import com.dh.proyectoFinal.entity.Paciente;
import com.dh.proyectoFinal.service.DomicilioServiceImp;
import com.dh.proyectoFinal.service.PacienteServiceImp;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest

public class PacienteServiceTest {
    @Autowired
    private PacienteServiceImp pacienteService;

    //private DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());
    @Autowired
    private DomicilioServiceImp domicilioService;


    //@BeforeClass
    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardarPaciente (new Paciente("gutierrez","Juan","juancgutierrez@gmail.com",123,LocalDate.now(),domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardarPaciente(new Paciente("Micaela", "Perez", "99999999",564, LocalDate.now(), domicilio1));
    }


    @Test
    public void agregarYBuscarPacienteTest() {

        Domicilio domicilio = new Domicilio("Calle", 123, "Temperley", "Buenos Aires");
        Paciente p2 =new Paciente("Tomas", "Pereyra","juangmail.com" ,12345678, LocalDate.now(), domicilio);
        Paciente p = pacienteService.guardarPaciente(p2);
        Assert.assertNotNull(pacienteService.buscarXId(p.getId()));
    }




    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        Assert.assertFalse(pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }


}
