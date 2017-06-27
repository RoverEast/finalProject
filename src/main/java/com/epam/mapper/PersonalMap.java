package com.epam.mapper;

import com.epam.executor.Map;
import com.epam.models.Personal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 31.05.2017.
 */
public class PersonalMap implements Map<Personal> {

    private static final String ID = "id";
    private static final String PATIENT_ID = "patient_id";
    private static final String USER_ID = "user_ID";

    @Override
    public Personal setParams(ResultSet resultSet) throws SQLException {
        Personal personal = new Personal();
        personal.setId(resultSet.getLong(ID));
        personal.setPatient_id(resultSet.getInt(PATIENT_ID));
        personal.setUser_id(resultSet.getInt(USER_ID));
        return personal;
    }
}
