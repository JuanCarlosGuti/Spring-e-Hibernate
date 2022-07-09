package com.dh.proyectoFinal;

import com.dh.proyectoFinal.entity.Domicilio;
import com.dh.proyectoFinal.entity.Odontologo;
import com.dh.proyectoFinal.entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
public class OdontologoIntegracionTest {

    @Autowired
    private MockMvc mockMvc;


    public void cargarDataSet() {
        Odontologo odontologo0 = new Odontologo("Ramirez", "Juan", 34960);
        Odontologo odontologo1 = new Odontologo("Tibanta", "Maria", 56987);
        Odontologo odontologo2 = new Odontologo("Gonzalez", "Jose", 34897);
    }

    @Test
    public void listarPacientes() throws Exception {
        this.cargarDataSet();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/odontologos"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void buscarOdontologoXId() throws Exception {
        //Cargar un odontologo
        this.cargarDataSet();
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/odontologos/{id}","1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
        //Assert.assertEquals("application/json",response.getResponse().getContentType());
    }





    @Test
    public void registrarOdontologos() throws Exception {
        //Crea un nuevo objeto Odontologo
        Odontologo odontologo = new Odontologo("Ramirez", "Juan", 348971960);
        //Ahora se debe convertir el objeto a un String Json para enviarlo al REQUEST
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String odontolgoJson = writer.writeValueAsString(odontologo);;

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/odontologos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(odontolgoJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }



}
