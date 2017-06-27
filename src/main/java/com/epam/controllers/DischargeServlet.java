package com.epam.controllers;

import com.epam.models.User;
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
import java.util.ResourceBundle;

/**
 * Created by Администратор on 26.06.2017.
 */
@WebServlet("/discharge")
public class DischargeServlet extends HttpServlet {


    private UserService service;
    private PersonalService personalService;

    @Override
    public void init() throws ServletException {
        try {
            service = new UserService();
            personalService = new PersonalService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String locale = String.valueOf((request.getSession().getAttribute("locale")));
        String message = Discharge.chooseMessage(locale);
        System.out.println(message);
        request.setAttribute("message",message);
        request.getSession().setAttribute("message", message);
        User patient = (User) request.getSession().getAttribute("patient1");
        System.out.println(patient);
        Long patientId = patient.getId();
        Discharge.addUser(service.getById(patientId));
        System.out.println(Discharge.dischargeList);
        personalService.clearPatientPersonal(patientId);
        response.getWriter().write(message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
