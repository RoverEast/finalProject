package com.epam.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
    T setParams(ResultSet resultSet) throws SQLException;
}
