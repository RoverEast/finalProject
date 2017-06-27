package com.epam.services;

import com.epam.dao.OperationsDao;
import com.epam.executor.Executor;
import com.epam.models.Operations;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 02.06.2017.
 */
public class OperationsService {

    private OperationsDao operationsDao;

    public OperationsService() throws SQLException {
        operationsDao = new OperationsDao(new Executor(ConnectionFactory.getInstance().getConnection()));
    }

    public List<Operations> getAllUserOperations(Long id) {
        return operationsDao.findAllPatientOperationsById(id);
    }

    public List<Operations> getAllOperations() {
        return operationsDao.findAll();
    }

    public Operations findByID(Long id){
        return operationsDao.IdFind(id);
    }

    public boolean checkOperationId(Long patientId,Long operationId) {
        return operationsDao.IdFind(patientId,operationId) != null;
    }
}

