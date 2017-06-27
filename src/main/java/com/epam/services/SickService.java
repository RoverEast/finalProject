package com.epam.services;

import com.epam.dao.SickDao;
import com.epam.executor.Executor;
import com.epam.models.Sick;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 30.05.2017.
 */
public class SickService {

    private SickDao sickDao;

    public SickService() throws SQLException {
        sickDao = new SickDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    public List<Sick> getAllUserSick(Long id) {
        return sickDao.findAllPatientSicksById(id);
    }

    public List<Sick> getAllSicks() {
        return sickDao.findAll();
    }

    public Sick findByID(Long id){
        return sickDao.IdFind(id);
    }

    public boolean checkSickId(Long patientId,Long sickId) {
        return sickDao.IdFind(patientId,sickId) != null;
    }

}
