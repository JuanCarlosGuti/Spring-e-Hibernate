package com.dh.proyectoFinal;

import com.dh.proyectoFinal.entity.Domicilio;
import com.dh.proyectoFinal.entity.Paciente;
import com.dh.proyectoFinal.service.DomicilioServiceImp;
import com.dh.proyectoFinal.service.PacienteServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class PacienteIntegracionTest {

    @Autowired
    private PacienteServiceImp pacienteService;

    @Autowired
    private DomicilioServiceImp domicilioService;

    @Autowired
    private MockMvc mockMvc;

    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardarPaciente (new Paciente("gutierrez","Juan","juancgutierrez@gmail.com",123, LocalDate.now(),domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardarPaciente(new Paciente("Micaela", "Perez", "99999999",564, LocalDate.now(), domicilio1));
    }

    @Test
    public void listarPacientes() throws Exception {
        this.cargarDataSet();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/paciente/lista"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void buscarPacienteXId() throws Exception {
        //Cargar un paciente
        this.cargarDataSet();
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/paciente/{id}","1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
        //Assert.assertEquals("application/json",response.getResponse().getContentType());
    }






}
