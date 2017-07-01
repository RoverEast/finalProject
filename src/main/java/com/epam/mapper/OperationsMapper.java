package com.epam.mapper;

import com.epam.executor.Mapper;
import com.epam.models.Operations;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationsMapper implements Mapper<Operations> {

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
