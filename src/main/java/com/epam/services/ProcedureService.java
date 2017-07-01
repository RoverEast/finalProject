package com.epam.services;

import com.epam.dao.ProceduresDao;
import com.epam.executor.Executor;
import com.epam.models.Procedures;

import java.sql.SQLException;
import java.util.List;


public class ProcedureService {

    private ProceduresDao proceduresDao;

    /**
     * create connection
     *
     * @throws SQLException
     */
    public ProcedureService() throws SQLException {
        proceduresDao = new ProceduresDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    /**
     * get all patient procedures
     *
     * @param id patient id
     * @return list of procedures
     */
    public List<Procedures> getAllUserProcedures(Long id) {
        return proceduresDao.findAllPatientProceduresById(id);
    }

    /**
     * get all procedures
     *
     * @return list of procedures
     */
    public List<Procedures> getAllProcedures() {
        return proceduresDao.findAll();
    }

    /**
     * check if user has procedure
     *
     * @param patientId   patient id
     * @param procedureId proceure id
     * @return true if has
     */
    public boolean checkProcedureId(Long patientId, Long procedureId) {
        return proceduresDao.idFind(patientId, procedureId) != null;
    }
}
