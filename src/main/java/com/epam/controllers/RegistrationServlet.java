package com.epam.controllers;

import com.epam.models.Position;
import com.epam.models.User;
import com.epam.services.UserService;
import com.epam.utils.View;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(RegistrationServlet.class);
    private UserService service;

    @Override
    public void init() throws ServletException{
        try {
            service = new UserService();
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String middlename = request.getParameter("middlename");
        String position = request.getParameter("position") ;
        String birthDate = request.getParameter("birthDate");
        if(StringUtils.isBlank(middlename))
            middlename="";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = null;
        try {
            date = dateFormat.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error(e);
        }
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date bDate = java.sql.Date.valueOf(dateFormat1.format(date));
        User user = new User(username,password,Position.valueOf(position),firstName,secondName,middlename,bDate);
        if (service.addUser(user)){
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("account").forward(request,response);
        }else {
            View.viewPage("registration",request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        View.viewPage("registration",request,response);
    }
}
