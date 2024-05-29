package com.mycompany.tb2;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private PersonService personService;

    @Override
    public void init() throws ServletException {
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String email = null;
        if (session != null) {
            email = (String) session.getAttribute("email");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
        request.setAttribute("email", email);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (personService.validate(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("person");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login-failed.jsp");
            dispatcher.forward(request, response);
        }
    }
}