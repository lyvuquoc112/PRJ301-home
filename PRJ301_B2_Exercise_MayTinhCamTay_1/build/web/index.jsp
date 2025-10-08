<%-- 
    Document   : index
    Created on : Sep 4, 2025, 4:02:07 PM
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
        <h1>Máy tính</h1>
        
        <form method ="GET" action="calculate">
            Number 1: <input type="text" name="num1" value="" /> <br>
            Number 2: <input type="text" name="num2" value="" /> <br>
            <input type="radio" name="phepTinh" value="cộng" /> + <br>
            <input type="radio" name="phepTinh" value="trừ" /> - <br>
            <input type="radio" name="phepTinh" value="nhân" /> x <br>
            <input type="radio" name="phepTinh" value="chia" /> : <br>
            <input type="submit" value="CALCULATE" />
        </form>
        <% String error = (String) request.getAttribute("msg");
            Double result = (Double) request.getAttribute("re");
        %>
        
        <% if(error != null && error.isEmpty()==false) { %>
        <%= error %>
        <% } %>
        
        <% if (result != null) { %>
        <%= result %>
        <% } %>
        
        
        
    </body>
    
   
</html>
