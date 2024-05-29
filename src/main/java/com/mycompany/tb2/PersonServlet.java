/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.tb2;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Baby
 */
@WebServlet(name = "PersonServlet", urlPatterns = {"/person"})
public class PersonServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertPerson(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updatePerson(request, response);
                break;
            case "/delete":
                deletePerson(request, response);
                break;

            default:
                listPerson(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPerson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String password = request.getParameter("password");
        Person newPerson = new Person(name, email, country, password);
        new PersonService().savePerson(newPerson);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Person existingPerson = new PersonService().getPerson(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personForm.jsp");
        request.setAttribute("person", existingPerson);
        dispatcher.forward(request, response);
    }

    private void updatePerson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String password = request.getParameter("password");

        Person person = new Person(id, name, email, country, password);
        new PersonService().updatePerson(person);
        response.sendRedirect("list");
    }

    private void deletePerson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        new PersonService().deletePerson(id);
        response.sendRedirect("list");
    }

    private void listPerson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Person> listPerson = new PersonService().getAllPerson();
        request.setAttribute("listPerson", listPerson);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
