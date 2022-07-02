package service;

import dao.IDao;
import model.Paciente;

import java.util.List;

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
}
