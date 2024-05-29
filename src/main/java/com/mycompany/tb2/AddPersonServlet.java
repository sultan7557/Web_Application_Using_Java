package com.mycompany.tb2;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddPersonServlet", urlPatterns = {"/new"}) // Changed the URL pattern
public class AddPersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve any necessary data for the form, like a list of projects
        List<Project> projects = new ProjectService().getAllProjects();
        request.setAttribute("projects", projects);

        // Forward to the addPerson.jsp page
        request.getRequestDispatcher("/WEB-INF/addPerson.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String password = request.getParameter("password");

        // Create a new Person with the selected project
        Person newPerson = new Person(name, email, country, password);
        newPerson.setPassword(password);
        new PersonService().savePerson(newPerson);

        // Redirect to the list servlet or any other appropriate page
        response.sendRedirect("listPersons");
    }

    @Override
    public String getServletInfo() {
        return "Servlet for adding a new person";
    }
}
