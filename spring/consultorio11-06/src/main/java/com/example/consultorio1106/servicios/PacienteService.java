package com.example.consultorio1106.servicios;




import com.example.consultorio1106.DAO.IDao;
import com.example.consultorio1106.dominio.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private IDao<Paciente> pacienteDao;

    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente buscarPaciente(int id){
        return pacienteDao.buscar(id);
    }

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteDao.guardar(paciente);
    }

    public void eliminarPaciente(int id){
        pacienteDao.eliminar(id);
    }
    public List<Paciente> buscarTodosPacientes(){
        return pacienteDao.buscarTodos();
    }
    public Paciente buscarXEmail(String email) {
        return pacienteDao.buscarXCriterio(email);
    }
}
