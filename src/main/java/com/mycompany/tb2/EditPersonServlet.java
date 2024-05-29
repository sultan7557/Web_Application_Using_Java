package com.mycompany.tb2;

import java.io.IOException;
import java.util.List;

import org.hibernate.Hibernate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EditPersonServlet", urlPatterns = {"/edit"})
public class EditPersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the person ID from the request parameter
        int personId = Integer.parseInt(request.getParameter("id"));

        // Retrieve the existing person from the database
        PersonService personService = new PersonService();
        Person existingPerson = personService.getPerson(personId);

        // Initialize the projects collection of the Person object
        Hibernate.initialize(existingPerson.getProjects());

        // Retrieve any necessary data for the form, like a list of projects
        List<Project> projects = new ProjectService().getAllProjects();
        request.setAttribute("projects", projects);

        // Set the existing person and forward to the editPerson.jsp page
        request.setAttribute("person", existingPerson);
        request.getRequestDispatcher("/WEB-INF/editPerson.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        // int project_id = Integer.parseInt(request.getParameter("project_id"));

        // Retrieve the existing person from the database
        Person existingPerson = new PersonService().getPerson(id);

        // Update the existing person with the new data
        existingPerson.setName(name);
        existingPerson.setEmail(email);
        existingPerson.setCountry(country);

        // Save the updated person
        new PersonService().updatePerson(existingPerson);

        // Redirect to the list servlet or any other appropriate page
        response.sendRedirect("listPersons");
    }

    @Override
    public String getServletInfo() {
        return "Servlet for editing an existing person";
    }
}
