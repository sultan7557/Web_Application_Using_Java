<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
            }
            .signup-form {
                width: 300px;
                margin: 0 auto;
                background-color: #fff;
                border: 1px solid #ddd;
                padding: 20px;
                border-radius: 5px;
                color: #333;
            }
            .signup-form h2 {
                text-align: center;
                color: #007bff;
            }
            .signup-form input[type="text"],
            .signup-form input[type="password"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                margin-bottom: 20px;
            }
            .signup-form input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
            }
            .signup-form input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="signup-form">
            <h2>Signup Page</h2>
            <form action="<%=request.getContextPath()%>/signup" method="post">
                <input type="text" name="name" placeholder="Username"/>
                <input type="text" name="email" placeholder="User Email"/>
                <input type="password" name="password" placeholder="Password"/>
                <input type="submit" value="Signup"/>
            </form>
        </div>
    </body>
</html>