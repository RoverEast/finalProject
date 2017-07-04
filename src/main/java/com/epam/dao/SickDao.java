package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.SickMapper;
import com.epam.models.Sick;
import org.apache.log4j.Logger;

import java.util.List;

public class SickDao implements Dao<Sick, Long> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM sick";
    private static final String FIND_BY_ID = "SELECT sick.* FROM patient\n" +
            "INNER JOIN sick ON idSick = sick.id\n" +
            "WHERE user_ID = ? AND idSick = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM sick WHERE name= ?";
    private static final String SELECT_ALL_PATIENT_SICK = "SELECT sick.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN sick ON patient.idSick = sick.id\n" +
            "WHERE user.position = 3 AND user.ID = ?";

    private static Logger logger = Logger.getLogger(SickDao.class);
    private Executor executor;

    public SickDao(Executor executor) {
        this.executor = executor;
    }


    public Sick idFind(Long patientId, Long sickId) {
        return executor.selectOne(FIND_BY_ID, new SickMapper(),patientId,sickId);
    }

    @Override
    public Sick idFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new SickMapper(),id);
    }

    @Override
    public void idDelete(Long id) {
        logger.error(new UnsupportedOperationException());
        throw new  UnsupportedOperationException();
    }

    @Override
    public List<Sick> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new SickMapper());
    }


    public List<Sick> findAllPatientSicksById(Long id){
        return executor.selectList(SELECT_ALL_PATIENT_SICK, new SickMapper(), id);
    }
}
