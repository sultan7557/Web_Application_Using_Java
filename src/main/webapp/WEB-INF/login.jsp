<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
            }
            .login-form {
                width: 300px;
                margin: 0 auto;
                background-color: #fff;
                border: 1px solid #ddd;
                padding: 20px;
                border-radius: 5px;
                color: #333;
            }
            .login-form h2 {
                text-align: center;
                color: #007bff;
            }
            .login-form input[type="text"],
            .login-form input[type="password"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                margin-bottom: 20px;
            }
            .login-form input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
            }
            .login-form input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <% if (request.getAttribute("name")!=null) { %>
        <h3> Hello, <%=request.getAttribute("name")%></h3>
        <a href="<%=request.getContextPath()%>/logout">Logout</a>
        <% } else { %>
        <div class="login-form">
            <h2>Login Page</h2>
            <form action="<%=request.getContextPath()%>/login" method="post">
                <input type="text" name="email" placeholder="User Email"/>
                <input type="password" name="password" placeholder="Password"/>
                <input type="submit" value="Login"/>
            </form>
        </div>
        <% } %>
    </body>
</html>