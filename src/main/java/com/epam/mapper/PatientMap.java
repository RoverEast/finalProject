package com.epam.mapper;

import com.epam.models.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 29.05.2017.
 */
public class PatientMap implements com.epam.executor.Map<Patient> {

    private static final String ID = "id";
    private static final String ID_SICK = "idSick";
    private static final String ID_MIXTURES = "idMixtures";
    private static final String ID_OPERATIONS = "idOperations";
    private static final String USER_ID = "user_ID";
    private static final String ID_PROCEDURE = "idProcedure";

    @Override
    public Patient setParams(ResultSet resultSet) throws SQLException {
        Patient patient = new Patient();
        patient.setId(resultSet.getLong(ID));
        patient.setIdSick(resultSet.getLong(ID_SICK));
        patient.setIdMixture(resultSet.getLong(ID_MIXTURES));
        patient.setIdOperations(resultSet.getLong(ID_OPERATIONS));
        patient.setUser_ID(resultSet.getLong(USER_ID));
        patient.setIdProcedure(resultSet.getLong(ID_PROCEDURE));
        return patient;
    }
}
