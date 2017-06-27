package com.epam.services;

import com.epam.dao.MixturesDao;
import com.epam.executor.Executor;
import com.epam.models.Mixtures;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 02.06.2017.
 */
public class MixturesService {

    private MixturesDao mixturesDao;

    public MixturesService() throws SQLException {
        mixturesDao = new MixturesDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    public List<Mixtures> getAllUserMixtures(Long id) {
        return mixturesDao.findAllPatientMixturesById(id);
    }

    public List<Mixtures> getAllMixtures() {
        return mixturesDao.findAll();
    }

    public Mixtures findByID(Long id){
        return mixturesDao.IdFind(id);
    }

    public boolean checkMixtureId(Long patientId,Long mixtureId) {
        return mixturesDao.IdFind(patientId,mixtureId) != null;
    }
}
