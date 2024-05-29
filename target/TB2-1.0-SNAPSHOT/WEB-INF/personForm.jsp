<%@page import="com.mycompany.tb2.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person Management</title>
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
            input[type="text"], input[type="password"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                margin-bottom: 20px;
            }
            input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
            }
            input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="center">
            <h1>Person Management</h1>
            <h3><a href="new">Add New Person</a> | <a href="list">List All Persons</a></h3>
        </div>
        <div>
            <%
            Person person = null;
            if (request.getAttribute("person") != null) {
                person = (Person) request.getAttribute("person");
            %>

                <form action="update" method="post">
                <input type="hidden" name="id" value="<%=person.getId()%>"/>
                <table>
                    <tr>
                        <td>Person Name</td>
                        <td><input type="text" name="name" value="<%=person.getName()%>"/></td>
                    </tr>
                    <tr>
                        <td>Person Email</td>
                        <td><input type="text" name="email" value="<%=person.getEmail()%>"/></td>
                    </tr>
                    <tr>
                        <td>Person Country</td>
                        <td><input type="text" name="country" value="<%=person.getCountry()%>"/></td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Update"/>
                        </td>
                    </tr>
                </table>
                </form>

                <% } else { %>
                <form action="insert" method="post">
                <table border="0" cellpadding="5">
                    <tr>
                        <td>Person Name</td>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Person Email</td>
                        <td><input type="text" name="email"/></td>
                    </tr>
                    <tr>
                        <td>Person Country</td>
                        <td><input type="text" name="country"/></td>
                    </tr>
                    <tr>
                        <td>Person Password</td>
                        <td><input type="password" name="password"/></td>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Save"/>
                        </td>
                    </tr>
                </table>
                </form>
            <% } %>
        </div>
    </body>
</html>