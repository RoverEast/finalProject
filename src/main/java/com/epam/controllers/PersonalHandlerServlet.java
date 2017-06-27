package com.epam.controllers;

import com.epam.models.*;
import com.epam.services.*;
import com.epam.utils.Discharge;
import com.epam.utils.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 03.06.2017.
 */
@WebServlet("/handler")
public class PersonalHandlerServlet extends HttpServlet {

    private UserService service;
    private SickService sickService;
    private MixturesService mixturesService;
    private OperationsService operationsService;
    private ProcedureService procedureService;
    private PatientService patientService;
    private PersonalService personalService;

    @Override
    public void init() throws ServletException {
        try {
            service = new UserService();
            sickService = new SickService();
            mixturesService = new MixturesService();
            operationsService = new OperationsService();
            procedureService = new ProcedureService();
            patientService = new PatientService();
            personalService = new PersonalService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("personal handler post");
        String locale = String.valueOf((request.getSession().getAttribute("locale")));
        Long patientId = Long.parseLong(request.getParameter("patient"));
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().setAttribute("patient1", service.getById(patientId));
        User patient1 = service.getById(patientId);
        Patient patient = new Patient(0,0,0,0,patientId);
        List<Sick> sicks = sickService.getAllSicks();
        List<Mixtures> mixtures = mixturesService.getAllMixtures();
        List<Procedures> procedures = procedureService.getAllProcedures();
        List<Operations> operations = operationsService.getAllOperations();
        List<Sick> sickList = sickService.getAllUserSick(patientId);
        List<Mixtures> mixturesList = mixturesService.getAllUserMixtures(patientId);
        List<Operations> operationsList = operationsService.getAllUserOperations(patientId);
        List<Procedures> proceduresList = procedureService.getAllUserProcedures(patientId);
        request.setAttribute("sickList",sickList);
        request.setAttribute("mixturesList",mixturesList);
        request.setAttribute("operationsList",operationsList);
        request.setAttribute("proceduresList",proceduresList);
        request.setAttribute("patient",patient1);
        request.setAttribute("sicks",sicks);
        request.setAttribute("mixtures",mixtures);
        request.setAttribute("procedures",procedures);
        request.setAttribute("operations",operations);
        if(request.getParameter("addSick") != null){
            Long sickId = Long.parseLong(request.getParameter("sick"));
            if (!sickService.checkSickId(patientId,sickId)) {
                patient.setIdSick(sickId);
                patientService.addPatient(patient);
                response.sendRedirect("/handler");
            }
        }
        if(request.getParameter("addMixture") != null){
            Long mixtureId = Long.parseLong(request.getParameter("mixture"));
            if (!mixturesService.checkMixtureId(patientId,mixtureId)) {
                patient.setIdMixture(mixtureId);
                patientService.addPatient(patient);
                response.sendRedirect("/handler");
            }
        }
        if(request.getParameter("addOperations") != null){
            System.out.println("add Operation");
            Long operationId = Long.parseLong(request.getParameter("operations"));
            if (!operationsService.checkOperationId(patientId,operationId)) {
                patient.setIdOperations(operationId);
                patientService.addPatient(patient);
                response.sendRedirect("/handler");
            }
        }
        if(request.getParameter("addProcedure") != null){
            System.out.println("add Procedure");
            Long procedureId = Long.parseLong(request.getParameter("procedure"));
            if (!procedureService.checkProcedureId(patientId,procedureId)) {
                patient.setIdProcedure(procedureId);
                System.out.println(patient.getIdProcedure());
                patientService.addPatient(patient);
                response.sendRedirect("/handler");
            }
        }

        if (request.getParameter("healSick")!=null){
            System.out.println("healSick");
            Long sickId = Long.parseLong(request.getParameter("sick"));
            patientService.healSmth("idSick = ?",patientId,sickId);
            response.sendRedirect("/handler");
        }

        if (request.getParameter("healMixture")!=null){
            System.out.println("healMixture");
            Long mixtureId = Long.parseLong(request.getParameter("mixture"));
            patientService.healSmth("idMixtures = ?",patientId,mixtureId);
            response.sendRedirect("/handler");
        }

        if (request.getParameter("healOperations")!=null){
            System.out.println("healOperations");
            System.out.println(request.getParameter("operations"));
            Long operationId = Long.parseLong(request.getParameter("operations"));
            patientService.healSmth("idOperations = ?",patientId,operationId);
            response.sendRedirect("/handler");
        }

        if (request.getParameter("healProcedure")!=null){
            System.out.println("healProcedure");
            Long procedureId = Long.parseLong(request.getParameter("procedure"));
            patientService.healSmth("idProcedure = ?",patientId,procedureId);
            response.sendRedirect("/handler");
        }

        if (request.getParameter("select")!=null){
            if(user.getPosition().equals(Position.DOC)){
                View.viewPage("checkup",request,response);
            }else if (user.getPosition().equals(Position.NURSE)){
                View.viewPage("checkupNurse",request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("personal handler get");
        String locale = String.valueOf((request.getSession().getAttribute("locale")));
        User user = (User) request.getSession().getAttribute("user");
        User patient = (User) request.getSession().getAttribute("patient1");
        System.out.println(patient);
        Long patientId = patient.getId();

        List<Sick> sicks = sickService.getAllSicks();
        List<Mixtures> mixtures = mixturesService.getAllMixtures();
        List<Procedures> procedures = procedureService.getAllProcedures();
        List<Operations> operations = operationsService.getAllOperations();
        List<Sick> sickList = sickService.getAllUserSick(patientId);
        List<Mixtures> mixturesList = mixturesService.getAllUserMixtures(patientId);
        List<Operations> operationsList = operationsService.getAllUserOperations(patientId);
        List<Procedures> proceduresList = procedureService.getAllUserProcedures(patientId);
        request.setAttribute("sickList",sickList);
        request.setAttribute("mixturesList",mixturesList);
        request.setAttribute("operationsList",operationsList);
        request.setAttribute("proceduresList",proceduresList);
        request.setAttribute("patient",patient);
        request.setAttribute("sicks",sicks);
        request.setAttribute("mixtures",mixtures);
        request.setAttribute("procedures",procedures);
        request.setAttribute("operations",operations);
        request.setAttribute("message",request.getSession().getAttribute("message"));
        if (Discharge.checkUser(patient)){
            String message = Discharge.chooseMessage(locale);
            request.setAttribute("message",message);
        }
        if(user.getPosition().equals(Position.DOC)){
            View.viewPage("checkup",request,response);
        }else if (user.getPosition().equals(Position.NURSE)){
            View.viewPage("checkupNurse",request,response);
        }
    }
}
