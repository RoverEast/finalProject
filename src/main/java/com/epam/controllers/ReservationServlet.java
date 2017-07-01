package com.epam.controllers;

import com.epam.models.Patient;
import com.epam.models.Personal;
import com.epam.models.User;
import com.epam.services.PatientService;
import com.epam.services.PersonalService;
import com.epam.services.UserService;
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

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(ReservationServlet.class);
    private UserService service;
    private PatientService patientService;
    private PersonalService personalService;

    @Override
    public void init() throws ServletException {
        try {
            service = new UserService();
            patientService = new PatientService();
            personalService = new PersonalService();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (request.getParameter("reserv") != null) {
            int personalId1 = Integer.parseInt(request.getParameter("doc"));
            int personalId2 = Integer.parseInt(request.getParameter("nurse"));
            Patient patient = new Patient(0,0,0,0, user.getId());
            Personal personal1 = new Personal(user.getId(),personalId1);
            Personal personal2 = new Personal(user.getId(),personalId2);
            patientService.addPatient(patient);
            personalService.addPersonal(personal1);
            personalService.addPersonal(personal2);
            request.getRequestDispatcher("/account").forward(request, response);
        }
        List<User> docList = service.getAllInPosition(1);
        List<User> nurseList = service.getAllInPosition(2);
        request.setAttribute("docList", docList);
        request.setAttribute("nurseList", nurseList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get reservation");
        List<User> docList = service.getAllInPosition(1);
        List<User> nurseList = service.getAllInPosition(2);
        request.setAttribute("docList", docList);
        request.setAttribute("nurseList", nurseList);
        View.viewPage("patientPages/reservation", request, response);
    }
}
