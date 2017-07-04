package com.epam.controllers;

import com.epam.models.User;
import com.epam.services.*;
import com.epam.utils.Discharge;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/discharge")
public class DischargeServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(DischargeServlet.class);
    private UserService service;
    private PersonalService personalService;

    @Override
    public void init() throws ServletException {
        try {
            service = new UserService();
            personalService = new PersonalService();
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String locale = String.valueOf((request.getSession().getAttribute("locale")));
        String message = Discharge.chooseMessage(locale);
        request.setAttribute("message",message);
        request.getSession().setAttribute("message", message);
        User patient = (User) request.getSession().getAttribute("patient1");
        Long patientId = patient.getId();
        Discharge.addUser(service.getById(patientId));
        personalService.clearPatientPersonal(patientId);
        response.getWriter().write(message);
    }
}
