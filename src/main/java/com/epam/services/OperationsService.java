package com.epam.services;

import com.epam.dao.OperationsDao;
import com.epam.executor.Executor;
import com.epam.models.Operations;

import java.sql.SQLException;
import java.util.List;


public class OperationsService {

    private OperationsDao operationsDao;

    /**
     * create connection
     *
     * @throws SQLException
     */
    public OperationsService() throws SQLException {
        operationsDao = new OperationsDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    /**
     * get all user operations
     *
     * @param id user id
     * @return list of operations
     */
    public List<Operations> getAllUserOperations(Long id) {
        return operationsDao.findAllPatientOperationsById(id);
    }

    /**
     * get all operations
     *
     * @return list of operations
     */
    public List<Operations> getAllOperations() {
        return operationsDao.findAll();
    }

    /**
     * check if user has operation
     *
     * @param patientId   patient id
     * @param operationId operation id
     * @return true if has
     */
    public boolean checkOperationId(Long patientId, Long operationId) {
        return operationsDao.idFind(patientId, operationId) != null;
    }
}

