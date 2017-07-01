package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.MixturesMapper;
import com.epam.models.Mixtures;
import org.apache.log4j.Logger;

import java.util.List;


public class MixturesDao implements Dao<Mixtures, Long> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM mixtures";
    private static final String FIND_BY_ID = "SELECT mixtures.* FROM patient\n" +
            "INNER JOIN mixtures ON idMixtures = mixtures.id\n" +
            "WHERE user_ID = ? AND idMixtures = ?";
    private static final String SELECT_ALL_PATIENT_MIXTURES = "SELECT mixtures.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN mixtures ON patient.idMixtures = mixtures.id\n" +
            "WHERE user.position = 3 AND user.ID = ?";

    private static Logger logger = Logger.getLogger(MixturesDao.class);
    private Executor executor;

    public MixturesDao(Executor executor) {
        this.executor = executor;
    }

    public Mixtures idFind(Long patientId, Long mixturesId) {
        return executor.selectOne(FIND_BY_ID, new MixturesMapper(),patientId,mixturesId);
    }

    @Override
    public Mixtures idFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new MixturesMapper(),id);
    }

    @Override
    public void idDelete(Long id) {
        logger.error(new UnsupportedOperationException());
        throw new  UnsupportedOperationException();
    }

    @Override
    public List<Mixtures> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new MixturesMapper());
    }

    public List<Mixtures> findAllPatientMixturesById(Long id){
        return executor.selectList(SELECT_ALL_PATIENT_MIXTURES, new MixturesMapper(), id);
    }
}
