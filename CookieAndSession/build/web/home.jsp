<%-- 
    Document   : home
    Created on : Sep 30, 2025, 10:52:09 AM
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
        <h1>Hello ${sessionScope.username}!</h1>
        <a href="logout">Logout</a>
    </body>
</html>
