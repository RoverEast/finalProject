package com.epam.mapper;

import com.epam.executor.Mapper;
import com.epam.models.Procedures;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 02.06.2017.
 */
public class ProceduresMapper implements Mapper<Procedures> {

    private static final String ID = "id";
    private static final String NAME = "name";

    @Override
    public Procedures setParams(ResultSet resultSet) throws SQLException {
        Procedures procedures = new Procedures();
        procedures.setId(resultSet.getLong(ID));
        procedures.setName(resultSet.getString(NAME));
        return procedures;
    }
}
