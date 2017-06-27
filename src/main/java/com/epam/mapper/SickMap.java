package com.epam.mapper;

import com.epam.executor.Map;
import com.epam.models.Sick;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 25.05.2017.
 */
public class SickMap implements Map<Sick>{

    private static final String ID = "id";
    private static final String NAME = "name";

    @Override
    public Sick setParams(ResultSet resultSet) throws SQLException {
        Sick sick = new Sick();
        sick.setId(resultSet.getLong(ID));
        sick.setName(resultSet.getString(NAME));
        return sick;
    }
}
