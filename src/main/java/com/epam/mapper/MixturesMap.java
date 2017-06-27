package com.epam.mapper;

import com.epam.models.Mixtures;
import com.epam.executor.Map;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 27.05.2017.
 */
public class MixturesMap implements Map<Mixtures> {

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
