package consultorio.com;

import consultorio.com.DAO.OdontologoDAOH2;
import consultorio.com.entidades.Odontologo;
import consultorio.com.service.OdontoloService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Odontologo odontologo = new Odontologo(256,"Juan", "Gutierrez");
        Odontologo odontologo1 = new Odontologo(352,"Jose","Garcia");


        OdontoloService odontoloService = new OdontoloService(new OdontologoDAOH2());

        odontoloService.registrarOdontologo(odontologo);
        odontoloService.registrarOdontologo(odontologo1);
        List<Odontologo> odontologos = odontoloService.listarOdontologos();
        for (Odontologo od:odontologos){
            System.out.println(od.getNombre());
        }



    }
}
