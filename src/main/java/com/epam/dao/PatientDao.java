package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.PatientMapper;
import com.epam.models.Patient;
import org.apache.log4j.Logger;

import java.util.List;

public class PatientDao implements Dao<Patient, Long> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM patient";
    private static final String FIND_BY_ID = "SELECT * FROM patient WHERE user_ID= ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM patient WHERE user_ID=?";

    private static final String DELETE_ROW = "DELETE patient.* FROM patient\n" +
            "INNER JOIN user ON patient.user_ID = user.ID\n" +
            "WHERE user_ID = ? AND ";

    private static final String INSERT_USER = "INSERT INTO patient(idSick, idMixtures, idOperations,idProcedure, user_ID) VALUES (?,?,?,?,?)";

    private static Logger logger = Logger.getLogger(PatientDao.class);
    private Executor executor;

    public PatientDao(Executor executor) {
        this.executor = executor;
    }

    @Override
    public Patient idFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new PatientMapper(), id);
    }

    @Override
    public void idDelete(Long id) {
        executor.execUpdate(DELETE_BY_ID_QUERY, id);
    }

    @Override
    public List<Patient> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new PatientMapper());
    }


    public void insertPatient(Patient patient) {
        executor.execUpdate(INSERT_USER, patient.getIdSick(), patient.getIdMixture(), patient.getIdOperations(), patient.getIdProcedure(), patient.getUser_ID());
    }

    public void deleteRow(String columnName,Long id, Long columnId) {
        executor.execUpdate(DELETE_ROW+columnName, id, columnId);
    }

}
