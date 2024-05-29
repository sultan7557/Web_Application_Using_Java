<%@page import="java.util.List"%>
<%@page import="com.mycompany.tb2.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                padding: 20px;
            }
            .center {
                text-align: center;
            }
            .center a {
                color: #007bff;
                text-decoration: none;
            }
            .center a:hover {
                color: #0056b3;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            table, th, td {
                border: 1px solid #ddd;
                padding: 10px;
            }
            th {
                background-color: #007bff;
                color: #fff;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            td a {
                color: #007bff;
                text-decoration: none;
            }
            td a:hover {
                color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="center">
            <h1>User Management</h1>
            <h3><a href="new">Add New Person</a> | <a href="listPersons">List All Persons</a></h3>
        </div>

        <div>
            <table>
                <caption><h2>List Of Persons</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Country</th>
                    <th>Actions</th>
                </tr>
                <%
                List<Person> listPerson = null;
                if (request.getAttribute("listPerson") !=null) {
                    listPerson = (List<Person>)request.getAttribute("listPerson");
                }
                for (Person person : listPerson) { 
                %>
                    <tr>
                        <td><%= person.getId() %></td>
                        <td><%= person.getName() %></td>
                        <td><%= person.getCountry() %></td>
                        <td>
                            <a href="edit?id=<%= person.getId() %>">Edit</a> -
                            <a href="deletePerson?id=<%= person.getId() %>">Delete</a>
                        </td>
                    </tr>
                <% } %>
            </table>
        </div>
    </body>
</html>