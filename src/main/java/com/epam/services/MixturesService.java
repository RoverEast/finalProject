package com.epam.services;

import com.epam.dao.MixturesDao;
import com.epam.executor.Executor;
import com.epam.models.Mixtures;

import java.sql.SQLException;
import java.util.List;


public class MixturesService {

    private MixturesDao mixturesDao;

    /**
     * create connection
     *
     * @throws SQLException
     */
    public MixturesService() throws SQLException {
        mixturesDao = new MixturesDao(new Executor());
    }

    /**
     * return all patient mixtures by id
     *
     * @param id patient id
     * @return list of mixtures
     */
    public List<Mixtures> getAllUserMixtures(Long id) {
        return mixturesDao.findAllPatientMixturesById(id);
    }

    /**
     * get all mixtures
     *
     * @return list of mixtures
     */
    public List<Mixtures> getAllMixtures() {
        return mixturesDao.findAll();
    }

    /**
     * check if user has mixture
     *
     * @param patientId patient id
     * @param mixtureId mixture id
     * @return true if has
     */
    public boolean checkMixtureId(Long patientId, Long mixtureId) {
        return mixturesDao.idFind(patientId, mixtureId) != null;
    }
}
