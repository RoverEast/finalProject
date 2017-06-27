package com.epam.mapper;

import com.epam.executor.Map;
import com.epam.models.Position;
import com.epam.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 25.05.2017.
 */
public class UserMap implements Map<User> {
    private static final String ID = "ID";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String POSITION = "position";
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String MIDLE_NAME = "midleName";
    private static final String BIRTH_DATE = "birthDate";


    @Override
    public User setParams(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(ID));
        user.setUserName(resultSet.getString(USERNAME));
        user.setPassword(resultSet.getString(PASSWORD));
        user.setPosition(Position.takePosition(resultSet.getInt(POSITION)));
        user.setFirstName(resultSet.getString(FIRST_NAME));
        user.setSecondName(resultSet.getString(SECOND_NAME));
        user.setMidletName(resultSet.getString(MIDLE_NAME));
        user.setBirtDate(resultSet.getDate(BIRTH_DATE));
        return user;
    }
}
