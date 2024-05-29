package com.mycompany.tb2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {
    private PersonService personService;

    @Override
    public void init() throws ServletException {
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Person newPerson = new Person();
        newPerson.setName(name);
        newPerson.setEmail(email);
        newPerson.setPassword(password); // Make sure to hash the password before storing

        personService.savePerson(newPerson);

        response.sendRedirect("login");
    }
}