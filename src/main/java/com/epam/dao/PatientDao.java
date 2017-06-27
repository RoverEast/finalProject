package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.PatientMap;
import com.epam.models.Patient;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Администратор on 29.05.2017.
 */

public class PatientDao implements Dao<Patient, Long> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM patient";
    private static final String FIND_BY_ID = "SELECT * FROM patient WHERE user_ID= ?";
    //private static final String FIND_BY_NAME = "SELECT * FROM patient WHERE name= ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM patient WHERE user_ID=?";

    private static final String DELETE_ROW = "DELETE patient.* FROM patient\n" +
            "INNER JOIN user ON patient.user_ID = user.ID\n" +
            "WHERE user_ID = ? AND ";

    private static final String INSERT_USER_ID_USER = "INSERT INTO patient (idSick,idMixtures,idOperations,user_ID) VALUES(0,0,0,?)";
    private static final String INSERT_USER = "INSERT INTO patient(idSick, idMixtures, idOperations,idProcedure, user_ID) VALUES (?,?,?,?,?)";

    /*private static final String SELECT_ALL_PATIENT_SICK = "SELECT sick.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN sick ON patient.idSick = sick.id\n" +
            "WHERE user.position = 3 AND username = ?";

    private static final String SELECT_ALL_PATIENT_MIXTURES = "SELECT mixtures.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN mixtures ON patient.idMixtures = mixtures.id\n" +
            "WHERE user.position= 3 AND username = ?";

    private static final String SELECT_ALL_PATIENT_OPERATIONS = "SELECT operations.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN operations ON patient.idOperations = operations.id\n" +
            "WHERE user.position= 3 AND username = ?";*/

    private static Logger logger = Logger.getLogger(PatientDao.class);
    private Executor executor;

    public PatientDao(Executor executor) {
        this.executor = executor;
    }

    @Override
    public Patient IdFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new PatientMap(), id);
    }

    @Override
    public void idDelete(Long id) {
        executor.execUpdate(DELETE_BY_ID_QUERY, id);
    }

    @Override
    public List<Patient> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new PatientMap());
    }


    public int insertPatient(Patient patient) {
        return executor.execUpdate(INSERT_USER, patient.getIdSick(), patient.getIdMixture(), patient.getIdOperations(),patient.getIdProcedure(), patient.getUser_ID());
    }

    public int insertPatientID(Patient patient,Long id) {
        return executor.execUpdate(INSERT_USER_ID_USER, patient.getUser_ID(),id);
    }

    public void deleteRow(String columnName,Long id, Long columnId) {
        executor.execUpdate(DELETE_ROW+columnName, id, columnId);
    }

}
