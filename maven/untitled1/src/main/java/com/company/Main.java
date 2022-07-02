package com.company;

import com.company.entidades.EstudianteDaoH2;
import com.company.entidades.Estudiantes;
import com.company.entidades.Medicamento;
import com.company.entidades.MedicamentosDAO2;
import com.company.servicios.EstuadianteService;
import com.company.servicios.MedicamentosService;

public class Main {
    public static void main(String[] args) {
        Estudiantes estudiantes = new Estudiantes();
        Estudiantes estudiantes1 = new Estudiantes();
        Estudiantes estudiantes2 = new Estudiantes();
        Estudiantes estudiantes3 = new Estudiantes();


        Medicamento medicamento = new Medicamento(1,"Parecetamol","phizer",30,525.25,1l);
        Medicamento medicamento1 = new Medicamento("Aspirina",650.25,2l);



        estudiantes.setId(1L);
        estudiantes.setNombre("Juan");
        estudiantes.setApellido("angel");
        estudiantes1.setId(2L);
        estudiantes1.setNombre("carlos");
        estudiantes1.setApellido("gut");
        estudiantes2.setId(3L);
        estudiantes2.setNombre("Juan");
        estudiantes2.setApellido("Huerfano");
        estudiantes3.setId(4L);
        estudiantes3.setNombre("Maria");
        estudiantes3.setApellido("Garcia");

        EstuadianteService estuadianteService = new EstuadianteService();
        //seteamos estrategia de H2
        estuadianteService.setEstudiantesIDao(new EstudianteDaoH2());
        estuadianteService.guardarEstudiante(estudiantes3);


        System.out.println(estuadianteService.buscarTodos());

        MedicamentosService medicamentosService = new MedicamentosService();
        medicamentosService.setMedicamentoIDao( new MedicamentosDAO2());


        medicamentosService.guardarMedicamento(medicamento);

        System.out.println(medicamentosService.buscarMedicamento(1l));







    }
}
