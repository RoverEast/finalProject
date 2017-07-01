package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.OperationsMapper;
import com.epam.models.Operations;
import org.apache.log4j.Logger;

import java.util.List;

public class OperationsDao implements Dao<Operations,Long> {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM operations";
    private static final String FIND_BY_ID = "SELECT operations.* FROM patient\n" +
            "INNER JOIN operations ON idOperations = operations.id\n" +
            "WHERE user_ID = ? AND idOperations = ?";
    private static final String SELECT_ALL_PATIENT_OPERATIONS = "SELECT operations.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN operations ON patient.idOperations = operations.id\n" +
            "WHERE user.position = 3 AND user.ID = ?";

    private static Logger logger = Logger.getLogger(OperationsDao.class);
    private Executor executor;

    public OperationsDao(Executor executor) {
        this.executor = executor;
    }

    public Operations idFind(Long patientId, Long operationsId) {
        return executor.selectOne(FIND_BY_ID, new OperationsMapper(),patientId,operationsId);
    }

    @Override
    public Operations idFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new OperationsMapper(),id);
    }

    @Override
    public void idDelete(Long id) {
        logger.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Operations> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new OperationsMapper());
    }

    public List<Operations> findAllPatientOperationsById(Long id){
        return executor.selectList(SELECT_ALL_PATIENT_OPERATIONS, new OperationsMapper(), id);
    }
}
