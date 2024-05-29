<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Failed</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .message-container {
                background-color: #fff;
                border: 1px solid #ddd;
                padding: 20px;
                border-radius: 5px;
                color: #333;
                text-align: center;
            }
            .message-container h1 {
                color: #007bff;
            }
            .message-container a {
                display: inline-block;
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                text-decoration: none;
                border-radius: 5px;
            }
            .message-container a:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="message-container">
            <h1>Login Failed. Please try again!</h1>
            <a href="<%=request.getContextPath()%>/login">Login</a>
        </div>
    </body>
</html>