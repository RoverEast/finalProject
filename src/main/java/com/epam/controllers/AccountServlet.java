package com.epam.controllers;

import com.epam.models.Position;
import com.epam.models.User;
import com.epam.services.PatientService;
import com.epam.services.UserService;
import com.epam.utils.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Администратор on 29.05.2017.
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private UserService service;
    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        try {
            service = new UserService();
            patientService = new PatientService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("account servlet get");
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        if (user.getPosition().equals(Position.NURSE))
            resp.sendRedirect("/nurse");
        //req.getRequestDispatcher("NurseServlet").forward(req, resp);
        if (user.getPosition().equals(Position.DOC))
            resp.sendRedirect("/doc");
        //System.out.println(req.getParameter("user"));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("account servlet post");
        User user = (User) req.getSession().getAttribute("user");
        req.getSession().removeAttribute("message");
        req.setAttribute("user", user);
        if (user.getPosition().equals(Position.NURSE))
            resp.sendRedirect("/nurse");
            //req.getRequestDispatcher("NurseServlet").forward(req, resp);
        if (user.getPosition().equals(Position.DOC))
            resp.sendRedirect("/doc");
            //req.getRequestDispatcher("DocServlet").forward(req, resp);
        if (user.getPosition().equals(Position.PATIENT))
            if (patientService.checkUserByUserId(user.getId())) {
                resp.sendRedirect("patient");
            } else
                resp.sendRedirect("reservation");
//        if (user.getPosition().equals(Position.PATIENT))
//            resp.sendRedirect("/PatientServlet");
//            //req.getRequestDispatcher("PatientServlet").forward(req, resp);
    }
}
