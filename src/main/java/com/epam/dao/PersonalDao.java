package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.models.Personal;

import java.util.List;
import org.apache.log4j.Logger;

public class PersonalDao implements Dao<Personal,Long> {

    private static Logger logger = Logger.getLogger(PersonalDao.class);
    private Executor executor;

    private static final String INSERT_USER = "INSERT INTO personal(patient_id, user_ID) VALUES (?,?)";
    private static final String DELETE_BY_PATIENT_ID= "DELETE FROM personal\n" +
            "WHERE patient_id = ?";

    public PersonalDao(Executor executor) {
        this.executor = executor;
    }

    public void insertPersonal(Personal personal) {
        executor.execUpdate(INSERT_USER, personal.getPatient_id(), personal.getUser_id());
    }

    @Override
    public Personal idFind(Long id) {
        logger.error(new UnsupportedOperationException());
        throw new  UnsupportedOperationException();
    }

    public void idDelete(Long id) {
        executor.execUpdate(DELETE_BY_PATIENT_ID, id);
    }

    @Override
    public List<Personal> findAll() {
        logger.error(new UnsupportedOperationException());
        throw new  UnsupportedOperationException();
    }
}
