<%-- 
    Document   : welcome
    Created on : Sep 4, 2025, 2:43:15 PM
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
        <%
        String name = (String) request.getAttribute("nAdmin");
        %>
        <h1>Hello <%= name %>!</h1>
    </body>
</html>
