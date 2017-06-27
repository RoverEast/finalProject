package com.epam.services;

import com.epam.dao.PatientDao;
import com.epam.executor.Executor;
import com.epam.models.Patient;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 30.05.2017.
 */
public class PatientService {

    PatientDao patientDao;

    public PatientService() throws SQLException {
        patientDao = new PatientDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    public void deleteUserById(Long id) {
        patientDao.idDelete(id);
    }

    public List<Patient> getAllUsers() {
        return patientDao.findAll();
    }

/*  public List getAllUserSick(Long id) {
        return patientDao.findAllPatientOperationsById(id);
    }

    public List getAllUserProcedures(Long id) {
        return patientDao.findAllPatientOperationsById(id);
    }

    //public List getAllUserProcedures(Long id) {
        return patientDao.findAllPatientMixturesById(id);
    }*/

    public boolean checkUserByUserId(Long id) {
        return patientDao.IdFind(id) != null;
    }

    public void addPatient(Patient patient) {
            patientDao.insertPatient(patient);
    }

    public void addUserID(Patient patient,long id) {
        patientDao.insertPatientID(patient,id);
    }

    public void healSmth(String columnName, Long id, Long columnId){
        patientDao.deleteRow(columnName,id,columnId);
    }
}
