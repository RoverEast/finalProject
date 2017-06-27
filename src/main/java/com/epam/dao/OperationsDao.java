package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.MixturesMap;
import com.epam.mapper.OperationsMap;
import com.epam.models.Mixtures;
import com.epam.models.Operations;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Администратор on 02.06.2017.
 */
public class OperationsDao implements Dao<Operations,Long> {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM operations";
    private static final String FIND_BY_ID = "SELECT operations.* FROM patient\n" +
            "INNER JOIN operations ON idOperations = operations.id\n" +
            "WHERE user_ID = ? AND idOperations = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM operations WHERE name= ?";
    private static final String SELECT_ALL_PATIENT_OPERATIONS = "SELECT operations.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN operations ON patient.idOperations = operations.id\n" +
            "WHERE user.position = 3 AND user.ID = ?";

    private static Logger logger = Logger.getLogger(OperationsDao.class);
    private Executor executor;

    public OperationsDao(Executor executor) {
        this.executor = executor;
    }

    public Operations IdFind(Long patientId,Long operationsId) {
        return executor.selectOne(FIND_BY_ID, new OperationsMap(),patientId,operationsId);
    }

    @Override
    public Operations IdFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new OperationsMap(),id);
    }

    @Override
    public void idDelete(Long id) {
        logger.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Operations> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new OperationsMap());
    }

    public List<Operations> findAllPatientOperationsById(Long id){
        return executor.selectList(SELECT_ALL_PATIENT_OPERATIONS, new OperationsMap(), id);
    }
}
