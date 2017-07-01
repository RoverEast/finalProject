package com.epam.controllers;

import com.epam.models.Position;
import com.epam.models.Sick;
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

@WebServlet(value = "/personal")
public class PersonalServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init() throws ServletException {
        try {
            service = new UserService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<User> patients = service.findAllPatients(user.getId());
        request.setAttribute("patients",patients);
        View.viewPage("personalPages/staffPage",request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<User> patients = service.findAllPatients(user.getId());
        request.setAttribute("patients",patients);
        View.viewPage("personalPages/staffPage",request,response);
    }
}
