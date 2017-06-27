package com.epam.controllers;

import com.epam.models.User;
import com.epam.services.SickService;
import com.epam.services.UserService;
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
 * Created by Администратор on 29.05.2017.
 */
@WebServlet("/nurse")
public class NurseServlet extends HttpServlet {
    private UserService service;
    private SickService sickService;

    @Override
    public void init() throws ServletException {
        try {
            service = new UserService();
            sickService = new SickService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("nurse Servlet post");
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getId());
        List<User> patients = service.findAllPatients(user.getId());
        request.setAttribute("patients",patients);
        View.viewPage("nursePage",request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getId());
        List<User> patients = service.findAllPatients(user.getId());
        request.setAttribute("patients",patients);
        View.viewPage("nursePage",request,response);
    }
}

