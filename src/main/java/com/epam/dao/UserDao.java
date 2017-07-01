package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.UserMapper;
import com.epam.models.User;

import java.util.List;
import org.apache.log4j.Logger;

public class UserDao implements Dao<User, Long> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM user";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE ID= ?";
    private static final String FIND_BY_USENAME = "SELECT * FROM user WHERE username= ?";
    private static final String FIND_BY_POSITION = "SELECT * FROM user WHERE position= ?";
    private static final String FIND_BY_SECOND_NAME = "SELECT * FROM user WHERE secondName= ?";
    private static final String INSERT_USER = "INSERT INTO user (username,password,position,firstName,secondName,midleName,birthDate) VALUES(?,?,?,?,?,?,?)";
    private static final String FIND_USER_PERSONAL_BY_PERSONAL_POSITION ="SELECT user.* FROM user\n" +
            "INNER JOIN personal ON personal.user_ID = user.ID\n" +
            "WHERE position = ? AND patient_id = ?";

    private static final String FIND_ALL_PERSONAL_PATIENTS = "SELECT user.* FROM user\n" +
            "INNER JOIN personal ON personal.patient_id = user.ID\n" +
            "WHERE user_ID = ?";

    private static Logger logger = Logger.getLogger(UserDao.class);
    private Executor executor;

    public UserDao(Executor executor) {
        this.executor = executor;
    }

    @Override
    public User idFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new UserMapper(),id);
    }

    public User findPersonal(int position, long patintId){
        return executor.selectOne(FIND_USER_PERSONAL_BY_PERSONAL_POSITION, new UserMapper(), position, patintId);
    }

    public List<User> findAllPatientsById(Long id) {
        return executor.selectList(FIND_ALL_PERSONAL_PATIENTS, new UserMapper(),id);
    }

    public User LoginFind(String username) {
        return executor.selectOne(FIND_BY_USENAME, new UserMapper(),username);
    }

    @Override
    public void idDelete(Long id) {
        logger.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new UserMapper());
    }

    public void insertUser(User user){
        executor.execUpdate(INSERT_USER, user.getUserName(), user.getPassword(), user.getPosition(), user.getFirstName(), user.getSecondName(), user.getMidletName(),
                user.getBirtDate());
    }

    public User userNameFind(String username) {
        return executor.selectOne(FIND_BY_USENAME, new UserMapper(),username);
    }

    public List<User> findByPosition(int position) {
        return executor.selectList(FIND_BY_POSITION, new UserMapper(),position);
    }


}
