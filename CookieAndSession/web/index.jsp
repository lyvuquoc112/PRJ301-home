<%-- 
    Document   : index
    Created on : Sep 30, 2025, 10:34:31 AM
    Author     : hanly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        <h1>Login</h1>
        <%
            String username = null;
            
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("username")) {
                            username = c.getValue();
                        }
                    }
                }
            
        %>
        
        
        
        
        
        <form action="login" method="POST">
            Username: <input type="text" name="username" value="<%=username%>" /> <br>
            Password: <input type="password" name="password" value="" /><br>
            <input type="checkbox" name="remember"/> Save user <br>
            <input type="submit" value="LOGIN" name="btAction" />
        </form>
    </body>
</html>
 