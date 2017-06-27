package com.epam.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shpetny Eugene
 * @version 1.0
 * */

public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
