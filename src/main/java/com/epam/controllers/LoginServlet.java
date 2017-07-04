package com.epam.controllers;

import com.epam.models.User;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    private static Logger logger = Logger.getLogger(LoginServlet.class);
    private UserService service;

    @Override
    public void init() throws ServletException{
        try {
            service = new UserService();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        View.viewPage("main",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("registration") != null){
            View.viewPage("registration",req,resp);
        }
        String login =  req.getParameter("login");
        String password =  req.getParameter("password");
        User user = service.getByLogin(login);
        if (user != null && service.checkPassword(user, password)) {
            req.getSession().setAttribute("user", user);
            logger.info("User login in the system");
            logger.info(user);
            req.getRequestDispatcher("account").forward(req,resp);
        } else {
            View.viewPage("main", req, resp);
        }
    }
}
