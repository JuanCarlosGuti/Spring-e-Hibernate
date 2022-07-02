package com.company.servicios;

import com.company.dao.IDao;
import com.company.entidades.Medicamento;

public class MedicamentosService {

    private IDao<Medicamento> medicamentoIDao;

    public IDao<Medicamento> getMedicamentoIDao(){
        return medicamentoIDao;
    }

    public void setMedicamentoIDao(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public void guardarMedicamento(Medicamento m){
        medicamentoIDao.guardar(m);
    }

    public void eliminarMedicamento(Long id){
        medicamentoIDao.eliminar(id);
    }
    public Medicamento buscarMedicamento(Long id){
        return medicamentoIDao.buscar(id);

    }
}
