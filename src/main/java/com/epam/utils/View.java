package com.epam.utils;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class View {

    private static final String PREFIX = "/WEB-INF/views/";
    private static final String SUFFIX = ".jsp";

    public static void viewPage(String pageName, HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher(PREFIX + pageName + SUFFIX).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
