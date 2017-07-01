package com.epam.controllers;

import com.epam.models.Position;
import com.epam.models.User;
import com.epam.services.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        try {
            patientService = new PatientService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        resp.sendRedirect("personal");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.getSession().removeAttribute("message");
        req.setAttribute("user", user);
        if (user.getPosition().equals(Position.PATIENT))
            if (patientService.checkUserByUserId(user.getId())) {
                resp.sendRedirect("patient");
            } else
                resp.sendRedirect("reservation");
        else
            resp.sendRedirect("personal");
    }
}
