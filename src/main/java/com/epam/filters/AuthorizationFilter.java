package com.epam.filters;

import com.epam.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * The filter, which does not allow to work with the Administration menu, the user who has the role - USER
 * */
@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        User user = (User) req.getSession().getAttribute("user");

        if (user == null
                && ((!req.getRequestURI().equals("/login"))
                && (!req.getRequestURI().equals("/config/language"))
                && (!req.getRequestURI().equals("/registration")) )
                && (!req.getRequestURI().startsWith("/resources"))) {
            resp.sendRedirect("/login");
        } else {
            filterChain.doFilter(req, resp);
        }
    }
    @Override
    public void destroy() {
    }
}
