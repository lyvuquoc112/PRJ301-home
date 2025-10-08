<%-- 
    Document   : login
    Created on : Oct 8, 2025, 10:10:29 AM
    Author     : hanly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background: #f4f6f8;
                display: flex;
                height: 100vh;
                justify-content: center;
                align-items: center;
            }

            .login-container {
                background: white;
                padding: 30px;
                border-radius: 12px;
                box-shadow: 0px 4px 8px rgba(0,0,0,0.2);
                width: 350px;
            }

            h2 {
                text-align: center;
                margin-bottom: 20px;
                color: #333;
            }

            input[type=text], input[type=password] {
                width: 100%;
                padding: 10px;
                margin: 8px 0 16px;
                border: 1px solid #ccc;
                border-radius: 6px;
                box-sizing: border-box;
            }

            button {
                width: 100%;
                padding: 12px;
                background: #007bff;
                border: none;
                border-radius: 6px;
                color: white;
                font-weight: bold;
                cursor: pointer;
            }

            button:hover {
                background: #0056b3;
            }

            .error{
                color: red;
                text-align: center;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>Account Login</h2>

            <!-- Hiển thị lỗi nếu có -->
                <div class="error">${requestScope.error}</div>

            <form action="login" method="post">
                <label>Username</label>
                <input type="text" name="username" required>

                <label>Password</label>
                <input type="password" name="password" required>

                <button type="submit">Login</button>
            </form>
        </div>
    </body>
</html>
