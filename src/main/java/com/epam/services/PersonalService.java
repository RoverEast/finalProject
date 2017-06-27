package com.epam.services;

import com.epam.dao.PersonalDao;
import com.epam.executor.Executor;
import com.epam.models.Personal;

import java.sql.SQLException;

/**
 * Created by Администратор on 31.05.2017.
 */
public class PersonalService {

    PersonalDao personalDao;

    public PersonalService() throws SQLException {
        personalDao = new PersonalDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    public void addPersonal(Personal personal) {
        personalDao.insertPersonal(personal);
    }

    public void clearPatientPersonal(Long id){
        personalDao.idDelete(id);
    }
}
