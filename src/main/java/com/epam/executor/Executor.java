package com.epam.executor;


import com.epam.models.Position;
import com.epam.services.ConnectionFactory;
import org.apache.log4j.Logger;

import java.security.PrivateKey;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Executor {

    private final Connection connection;
    private static ConnectionFactory pool = ConnectionFactory.getInstance();

    private static Logger logger = Logger.getLogger(Executor.class);

    public Executor() {
        this.connection = pool.getConnection();
    }

    public int execUpdate(String query, Object... params) {
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setParams(stmt, params);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
            throw new UnsupportedOperationException(e);
        } finally {
            pool.putConnection(connection);
        }
    }


    public <T> T selectOne(String query, Mapper<T> mapper, Object... params) {

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setParams(stmt, params);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return mapper.setParams(resultSet);
            } else {
                return null;
            }

        } catch (SQLException e) {
            logger.error(e);
            throw new UnsupportedOperationException(e);
        } finally {
            pool.putConnection(connection);
        }
    }

    public <T> List<T> selectList(String query, Mapper<T> mapper, Object... params) {

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setParams(stmt, params);
            List<T> list = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                list.add(mapper.setParams(resultSet));
            }
            return list;
        } catch (SQLException e) {
            throw new UnsupportedOperationException(e);
        } finally {
            pool.putConnection(connection);
        }
    }

    public <T> T execQuery(String query, ResultHandler<T> handler) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        result.close();
        stmt.close();
        return value;
    }

    private void setParams(PreparedStatement stmt, Object[] params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                try {
                    setParam(stmt, i + 1, params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                    logger.error(e);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }


    private void setParam(PreparedStatement stmt, int i, Object object) throws SQLException {
        if (object instanceof String) {
            stmt.setString(i, (String) object);
        } else if (object instanceof Integer) {
            stmt.setInt(i, (Integer) object);
        }else if (object instanceof Long) {
                stmt.setLong(i, (Long) object);
        }else if (object instanceof Date){
            stmt.setDate(i, (Date) object);
        }else if (object instanceof Position){
            stmt.setInt(i,2);
        }else {
            throw new IllegalArgumentException();
        }
    }
}