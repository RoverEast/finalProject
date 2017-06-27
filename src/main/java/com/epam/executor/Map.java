package com.epam.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 25.05.2017.
 */
public interface Map<T> {
    T setParams(ResultSet resultSet) throws SQLException;
}
