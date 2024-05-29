<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Person</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                padding: 20px;
            }
            label {
                display: block;
                margin-top: 20px;
            }
            input[type="text"], input[type="email"], input[type="password"], select {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                margin-top: 5px;
            }
            button[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
                margin-top: 20px;
            }
            button[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <h2>Add Person</h2>

        <form action="new" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        
            <label for="country">Country:</label>
            <input type="text" id="country" name="country" required>
        
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <!-- Dropdown for selecting projects -->
            <label for="project">Select Project:</label>
            <select name="project">
                <c:forEach var="project" items="${projects}">
                    <option value="${project.id}">${project.title}</option>
                </c:forEach>
            </select><br>

            <button type="submit">Add Person</button>
        </form>

    </body>
</html>