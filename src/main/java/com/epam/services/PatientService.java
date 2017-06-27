package com.epam.services;

import com.epam.dao.PatientDao;
import com.epam.executor.Executor;
import com.epam.models.Patient;

import java.sql.SQLException;
import java.util.List;


public class PatientService {

    PatientDao patientDao;

    /**
     * create connection
     *
     * @throws SQLException
     */
    public PatientService() throws SQLException {
        patientDao = new PatientDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    /**
     * delete patient
     *
     * @param id patient id
     */
    public void deleteUserById(Long id) {
        patientDao.idDelete(id);
    }

    /**
     * get all patients
     *
     * @return list of patients
     */
    public List<Patient> getAllUsers() {
        return patientDao.findAll();
    }

    /**
     * find patient
     *
     * @param id patient id
     * @return true if patient has been found
     */
    public boolean checkUserByUserId(Long id) {
        return patientDao.IdFind(id) != null;
    }

    /**
     * add patient
     *
     * @param patient patient with all parameters
     */
    public void addPatient(Patient patient) {
        patientDao.insertPatient(patient);
    }

    /**
     * heal patient
     *
     * @param columnName what heal
     * @param id         patient id
     * @param columnId   heal id
     */
    public void healSmth(String columnName, Long id, Long columnId) {
        patientDao.deleteRow(columnName, id, columnId);
    }
}
