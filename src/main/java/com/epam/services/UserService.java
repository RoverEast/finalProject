package com.epam.services;

import com.epam.dao.UserDao;
import com.epam.executor.Executor;
import com.epam.models.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 27.05.2017.
 */
public class UserService {

    UserDao userDao;

    public UserService() throws SQLException {
        userDao = new UserDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }
    
    public User getByLogin(String login) {
        return userDao.LoginFind(login);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public List<User> getAllInPosition(int position) {
        return userDao.findByPosition(position);
    }

    public void deleteUserById(Long id) {
        userDao.idDelete(id);
    }

    public User getById(Long id){
        return userDao.IdFind(id);
    }

    public User FindPersonal(int position, long patintId){
        return userDao.FindPersonal(position,patintId);
    }

    public List<User> findAllPatients(Long id) {
        return userDao.findAllPatientsById(id);
    }

    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    public boolean checkUserByLogin(String login) {
        return userDao.userNameFind(login) != null;
    }

    public boolean addUser(User user) {
        if (checkUserByLogin(user.getUserName())) {
            return false;
        } else {
            userDao.insertUser(user);
            return true;
        }
    }


}
