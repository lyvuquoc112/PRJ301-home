<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background: #f4f6f8;
                display: flex;
                height: 100vh;
                justify-content: center;
                align-items: center;
            }

            .register-container {
                background: white;
                padding: 30px;
                border-radius: 12px;
                box-shadow: 0px 4px 8px rgba(0,0,0,0.2);
                width: 400px;
            }

            h2 {
                text-align: center;
                margin-bottom: 20px;
                color: #333;
            }

            input[type=text], input[type=password], input[type=email] {
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
                background: #28a745;
                border: none;
                border-radius: 6px;
                color: white;
                font-weight: bold;
                cursor: pointer;
            }

            button:hover {
                background: #218838;
            }

            .error {
                color: red;
                text-align: center;
                margin-bottom: 15px;
            }
            .success {
                color: green;
                text-align: center;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="register-container">
            <h2>Create Account</h2>
            <!-- Hiển thị thông báo -->

            <div class="error">${requestScope.error}</div>



            <form action="register" method="post">
                <label>Username</label>
                <input type="text" name="username" required>

                <label>Password</label>
                <input type="password" name="password" required>

                <label>Email</label>
                <input type="email" name="email" required>

                <button type="submit">Register</button>
            </form>

            <p style="text-align:center; margin-top:10px;">
                Already have an account? <a href="login.jsp">Login</a>
            </p>
        </div>
    </body>
</html>