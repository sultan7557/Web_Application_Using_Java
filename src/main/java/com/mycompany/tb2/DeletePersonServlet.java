package com.mycompany.tb2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DeletePersonServlet", urlPatterns = {"/deletePerson"})
public class DeletePersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the person ID from the request parameter
        int personId = Integer.parseInt(request.getParameter("id"));

        // Delete the person from the database
        new PersonService().deletePerson(personId);

        // Redirect to the list servlet or any other appropriate page
        response.sendRedirect("listPersons");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handling POST requests, you can redirect to the doGet method
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for deleting a person";
    }
}
