package consultorio.com.service;

import consultorio.com.DAO.IDAO;
import consultorio.com.entidades.Odontologo;

import java.sql.SQLException;
import java.util.List;

public class OdontoloService {
    private IDAO<Odontologo> odontologoIDAO;

    public OdontoloService(IDAO<Odontologo> odontologoIDAO) {
        this.odontologoIDAO = odontologoIDAO;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoIDAO.registrar(odontologo);
    }
    public List<Odontologo> listarOdontologos(){
        try {
            return odontologoIDAO.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
