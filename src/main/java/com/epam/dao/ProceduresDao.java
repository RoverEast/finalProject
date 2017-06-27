package com.epam.dao;

import com.epam.executor.Executor;
import com.epam.mapper.OperationsMap;
import com.epam.mapper.ProceduresMap;
import com.epam.models.Operations;
import com.epam.models.Procedures;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Администратор on 02.06.2017.
 */
public class ProceduresDao implements Dao<Procedures, Long> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM procedures";
    private static final String FIND_BY_ID = "SELECT procedures.* FROM patient\n" +
            "INNER JOIN procedures ON idProcedure = procedures.id\n" +
            "WHERE user_ID = ? AND idProcedure = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM operations WHERE name= ?";
    private static final String SELECT_ALL_PATIENT_OPERATIONS = "SELECT procedures.* FROM user\n" +
            "INNER JOIN patient ON user.ID=user_ID\n" +
            "INNER JOIN procedures ON patient.idProcedure = procedures.id\n" +
            "WHERE user.position = 3 AND user.ID = ?";

    private static Logger logger = Logger.getLogger(ProceduresDao.class);
    private Executor executor;

    public ProceduresDao(Executor executor) {
        this.executor = executor;
    }

    public Procedures IdFind(Long patientId,Long procedureId) {
        return executor.selectOne(FIND_BY_ID, new ProceduresMap(),patientId,procedureId);
    }


    @Override
    public Procedures IdFind(Long id) {
        return executor.selectOne(FIND_BY_ID, new ProceduresMap(),id);
    }

    @Override
    public void idDelete(Long id) {
        logger.error(new UnsupportedOperationException());
        throw new  UnsupportedOperationException();
    }

    @Override
    public List<Procedures> findAll() {
        return executor.selectList(SELECT_ALL_QUERY, new ProceduresMap());
    }

    public List<Procedures> findAllPatientProceduresById(Long id){
        return executor.selectList(SELECT_ALL_PATIENT_OPERATIONS, new ProceduresMap(), id);
    }
}
