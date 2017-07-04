package com.epam.controllers;

import com.epam.utils.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/config/language")
public class LanguageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String locale = req.getParameter("lang");
        if (locale.equals("rus")){
            req.getSession().setAttribute("locale","ru_RU");
        }else{
            req.getSession().setAttribute("locale","en_EN");
        }
    }
}
