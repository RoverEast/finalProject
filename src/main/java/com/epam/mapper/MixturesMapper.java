package com.epam.mapper;

import com.epam.models.Mixtures;
import com.epam.executor.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MixturesMapper implements Mapper<Mixtures> {

    private static final String ID = "id";
    private static final String NAME = "name";


    @Override
    public Mixtures setParams(ResultSet resultSet) throws SQLException {
        Mixtures mixtures = new Mixtures();
        mixtures.setId(resultSet.getLong(ID));
        mixtures.setName(resultSet.getString(NAME));
        return mixtures;
    }
}
