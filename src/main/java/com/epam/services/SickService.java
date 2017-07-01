package com.epam.services;

import com.epam.dao.SickDao;
import com.epam.executor.Executor;
import com.epam.models.Sick;

import java.sql.SQLException;
import java.util.List;


public class SickService {

    private SickDao sickDao;

    /**
     * create connection
     *
     * @throws SQLException
     */
    public SickService() throws SQLException {
        sickDao = new SickDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    /**
     * get all patient sick
     *
     * @param id patient id
     * @return list of sick
     */
    public List<Sick> getAllUserSick(Long id) {
        return sickDao.findAllPatientSicksById(id);
    }

    /**
     * get all patient sick
     *
     * @return list of sick
     */
    public List<Sick> getAllSicks() {
        return sickDao.findAll();
    }

    /**
     * check if user has mixture
     *
     * @param patientId patient id
     * @param sickId    sick id
     * @return true if has
     */
    public boolean checkSickId(Long patientId, Long sickId) {
        return sickDao.idFind(patientId, sickId) != null;
    }

}
