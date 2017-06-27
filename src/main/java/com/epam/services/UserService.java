package com.epam.services;

import com.epam.dao.UserDao;
import com.epam.executor.Executor;
import com.epam.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    UserDao userDao;

    /**
     * create connection
     *
     * @throws SQLException
     */
    public UserService() throws SQLException {
        userDao = new UserDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    /**
     * find by login
     *
     * @param login login
     * @return user
     */
    public User getByLogin(String login) {
        return userDao.LoginFind(login);
    }

    /**
     * get all in current position
     *
     * @param position position
     * @return list of users
     */
    public List<User> getAllInPosition(int position) {
        return userDao.findByPosition(position);
    }

    /**
     * find by id
     *
     * @param id user id
     * @return user
     */
    public User getById(Long id) {
        return userDao.IdFind(id);
    }

    /**
     * find all patient personal
     *
     * @param position position
     * @param patintId patient id
     * @return personal
     */
    public User FindPersonal(int position, long patintId) {
        return userDao.FindPersonal(position, patintId);
    }

    /**
     * find all personal patients
     *
     * @param id personal id
     * @return list of patients
     */
    public List<User> findAllPatients(Long id) {
        return userDao.findAllPatientsById(id);
    }

    /**
     * check password
     *
     * @param user     user
     * @param password user password
     * @return true if equal
     */
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    /**
     * check user by login
     *
     * @param login user login
     * @return true if user has been found
     */
    public boolean checkUserByLogin(String login) {
        return userDao.userNameFind(login) != null;
    }

    /**
     * add user
     *
     * @param user user
     * @return true if user has been added
     */
    public boolean addUser(User user) {
        if (checkUserByLogin(user.getUserName())) {
            return false;
        } else {
            userDao.insertUser(user);
            return true;
        }
    }
}
