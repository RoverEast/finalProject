package com.epam.controllers;

import com.epam.models.*;
import com.epam.services.*;
import com.epam.utils.Discharge;
import com.epam.utils.View;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/patient")
public class PatientServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(PatientServlet.class);
    private UserService service;
    private SickService sickService;
    private MixturesService mixturesService;
    private OperationsService operationsService;
    private ProcedureService procedureService;
    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        try {
            service = new UserService();
            sickService = new SickService();
            mixturesService = new MixturesService();
            operationsService = new OperationsService();
            procedureService = new ProcedureService();
            patientService = new PatientService();
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        User doctor = service.findPersonal(1,user.getId());
        User nurse = service.findPersonal(2,user.getId());
        List<Sick> sickList = sickService.getAllUserSick(user.getId());
        List<Mixtures> mixturesList = mixturesService.getAllUserMixtures(user.getId());
        List<Operations> operationsList = operationsService.getAllUserOperations(user.getId());
        List<Procedures> proceduresList = procedureService.getAllUserProcedures(user.getId());
        request.setAttribute("doctor", doctor);
        request.setAttribute("nurse", nurse);
        request.setAttribute("sickList",sickList);
        request.setAttribute("mixturesList",mixturesList);
        request.setAttribute("operationsList",operationsList);
        request.setAttribute("proceduresList",proceduresList);
        request.setAttribute("user",user);

        if (request.getParameter("ok")!=null){
            Discharge.deleteUser(user);
            View.viewPage("main",request,response);
        }

        if (Discharge.checkUser(user)){
            View.viewPage("discharge",request,response);
            patientService.deleteUserById(user.getId());
        }
        if (!patientService.checkUserByUserId(user.getId()))
            request.getRequestDispatcher("reservation").forward(request, response);
        View.viewPage("patientPage",request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        User doctor = service.findPersonal(1,user.getId());
        User nurse = service.findPersonal(2,user.getId());
        List<Sick> sickList = sickService.getAllUserSick(user.getId());
        List<Mixtures> mixturesList = mixturesService.getAllUserMixtures(user.getId());
        List<Operations> operationsList = operationsService.getAllUserOperations(user.getId());
        List<Procedures> proceduresList = procedureService.getAllUserProcedures(user.getId());
        request.setAttribute("doctor", doctor);
        request.setAttribute("nurse", nurse);
        request.setAttribute("sickList",sickList);
        request.setAttribute("mixturesList",mixturesList);
        request.setAttribute("operationsList",operationsList);
        request.setAttribute("proceduresList",proceduresList);
        request.setAttribute("user",user);
        if (Discharge.checkUser(user)){
            View.viewPage("patientPages/discharge",request,response);
            patientService.deleteUserById(user.getId());
        }
        if (!patientService.checkUserByUserId(user.getId()))
            request.getRequestDispatcher("reservation").forward(request, response);
        View.viewPage("patientPages/patientPage",request,response);
    }
}

