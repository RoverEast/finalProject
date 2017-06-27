package com.epam.services;

import com.epam.dao.ProceduresDao;
import com.epam.executor.Executor;
import com.epam.models.Procedures;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 02.06.2017.
 */
public class ProcedureService {

    private ProceduresDao proceduresDao;

    public ProcedureService() throws SQLException {
        proceduresDao = new ProceduresDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    public List<Procedures> getAllUserProcedures(Long id) {
        return proceduresDao.findAllPatientProceduresById(id);
    }

    public List<Procedures> getAllProcedures() {
        return proceduresDao.findAll();
    }

    public Procedures findByID(Long id){
        return proceduresDao.IdFind(id);
    }

    public boolean checkProcedureId(Long patientId, Long procedureId) {
        return proceduresDao.IdFind(patientId,procedureId) != null;
    }
}
