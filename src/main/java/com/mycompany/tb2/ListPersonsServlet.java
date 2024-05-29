package com.mycompany.tb2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListPersonsServlet", urlPatterns = {"/listPersons"})
public class ListPersonsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the list of persons from the database
        List<Person> listPerson = new PersonService().getAllPerson();

        // Set the list in the request attribute for the JSP to use
        request.setAttribute("listPerson", listPerson);

        // Forward the request to the JSP page for rendering
        request.getRequestDispatcher("/WEB-INF/personList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handling POST requests, you can redirect to the doGet method
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for listing persons";
    }
}
