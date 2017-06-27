package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.MixturesMap;
import com.epam.mapper.SickMap;
import com.epam.models.Mixtures;
import com.epam.models.Sick;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Администратор on 27.05.2017.
 */
public class MixturesDao implements Dao<Mixtures, Long> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM mixtures";
    private static final String FIND_BY_ID = "SELECT mixtures.* FROM patient\n" +
            "INNER JOIN mixtures ON idMixtures = mixtures.id\n" +
            "WHERE user_ID = ? AND idMixtures = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM mixtures WHERE name= ?";
    private static final String SELECT_ALL_PATIENT_MIXTURES = "SELECT mixtures.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN mixtures ON patient.idMixtures = mixtures.id\n" +
            "WHERE user.position = 3 AND user.ID = ?";

    private static Logger logger = Logger.getLogger(MixturesDao.class);
    private Executor executor;

    public MixturesDao(Executor executor) {
        this.executor = executor;
    }

    public Mixtures IdFind(Long patientId,Long mixturesId) {
        return executor.selectOne(FIND_BY_ID, new MixturesMap(),patientId,mixturesId);
    }

    @Override
    public Mixtures IdFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new MixturesMap(),id);
    }

    @Override
    public void idDelete(Long id) {
        logger.error(new UnsupportedOperationException());
        throw new  UnsupportedOperationException();
    }

    @Override
    public List<Mixtures> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new MixturesMap());
    }

    public List<Mixtures> findAllPatientMixturesById(Long id){
        return executor.selectList(SELECT_ALL_PATIENT_MIXTURES, new MixturesMap(), id);
    }
}
