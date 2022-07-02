package service;


import com.dao.PacienteDAOH2;
import com.entidades.Domicilio;
import com.entidades.Paciente;
import com.service.PacienteService;
import com.util.Conexion;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceTest {

    @Test
    @Order(1)
    public void agregarYBuscarPacienteTest(){
        Conexion.crearTablas();
               //preparar el domicilio y el paciente
        Domicilio domicilioParaAgregar= new Domicilio("Calle C",584,"Salta",
                "Salta");
        Paciente pacienteParaAgregar=new Paciente("Pedro",584,
                LocalDate.of(2022,05,31), domicilioParaAgregar);
        PacienteService pacienteService= new PacienteService(new PacienteDAOH2());

        //guardar el paciente y buscarlo
        pacienteService.guardarPaciente(pacienteParaAgregar);
        Paciente pacienteResultado=pacienteService.buscarPaciente(3);

        assertEquals(pacienteParaAgregar.getDni(),pacienteResultado.getDni());
    }
    @Test
    @Order(2)
    public void eliminarPacienteID3Test(){
        //preprar nuestro domicilio y paciente de prueba
        PacienteService pacienteService=new PacienteService(new PacienteDAOH2());
        //usar el service
        pacienteService.eliminarPaciente(3);
        //realizar el assert
        assertTrue(pacienteService.buscarPaciente(3)==null);
    }
    @Test
    @Order(3)
    public void buscarTodosPacientesTest(){
        PacienteService pacienteService=new PacienteService(new PacienteDAOH2());
        //usar el service
        List<Paciente> pacienteList= pacienteService.buscarTodosPacientes();
        for (Paciente p:pacienteList) {
            System.out.println(p.getNombre());
        }
        //realizar el assert
        assertTrue(pacienteList.size()>0);
    }
}