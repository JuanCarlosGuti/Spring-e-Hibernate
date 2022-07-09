package com.dh.proyectoFinal;

import com.dh.proyectoFinal.entity.Domicilio;
import com.dh.proyectoFinal.entity.Odontologo;
import com.dh.proyectoFinal.entity.Paciente;
import com.dh.proyectoFinal.entity.Turno;
import com.dh.proyectoFinal.service.OdontologoServiceImp;
import com.dh.proyectoFinal.service.PacienteServiceImp;
import com.dh.proyectoFinal.service.TurnosImplementacion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TurnoIntegracionTest {
    @Autowired
    private PacienteServiceImp pacienteService;

    @Autowired
    private OdontologoServiceImp odontologoService;

    @Autowired
    private TurnosImplementacion turnoService;

    @Autowired
    private MockMvc mockMvc;


    public void cargarDataSet() {
        Odontologo odontologo = new Odontologo("Ramirez", "Juan", 348971960);
        Domicilio domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardarPaciente (new Paciente("gutierrez","Juan","juancgutierrez@gmail.com",123, LocalDate.now(),domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardarPaciente(new Paciente("Micaela", "Perez", "99999999",564, LocalDate.now(), domicilio1));

        Turno  turno = new Turno();
        turno.setOdontologo(odontologo);
        turno.setFecha(LocalDate.now());
        turno.setPaciente(p);

    }

    @Test
    public void listarLosTurnos() throws Exception {
        this.cargarDataSet();
        MvcResult rsponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/turnos"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assert.assertFalse(rsponse.getResponse().getContentAsString().isEmpty());
    }



}
