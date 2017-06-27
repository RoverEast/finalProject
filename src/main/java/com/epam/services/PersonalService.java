package com.epam.services;

import com.epam.dao.PersonalDao;
import com.epam.executor.Executor;
import com.epam.models.Personal;

import java.sql.SQLException;


public class PersonalService {

    PersonalDao personalDao;

    /**
     * create connection
     *
     * @throws SQLException
     */
    public PersonalService() throws SQLException {
        personalDao = new PersonalDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    /**
     * add personal
     *
     * @param personal personal with params
     */
    public void addPersonal(Personal personal) {
        personalDao.insertPersonal(personal);
    }

    /**
     * clear patient by idd
     *
     * @param id patient id
     */
    public void clearPatientPersonal(Long id) {
        personalDao.idDelete(id);
    }
}
