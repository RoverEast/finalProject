package com.epam.mapper;

import com.epam.executor.Map;
import com.epam.models.Operations;
import com.epam.models.Sick;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 02.06.2017.
 */
public class OperationsMap implements Map<Operations> {

    private static final String ID = "id";
    private static final String NAME = "name";

    @Override
    public Operations setParams(ResultSet resultSet) throws SQLException {
        Operations operations = new Operations();
        operations.setId(resultSet.getLong(ID));
        operations.setName(resultSet.getString(NAME));
        return operations;
    }
}
