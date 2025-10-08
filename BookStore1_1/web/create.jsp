<%-- 
    Document   : create
    Created on : Sep 23, 2025, 4:30:23 PM
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
        <h1>Add New Book</h1>
        <form method = "POST" action="main">
            Tittle: <input type="text" name="tittle" value="" /> <br>
            Published Date: <input type="date" name="publishedDate" value="" /> <br>
            Category <input type="text" name="category" value="" /><br>
            Price: <input type="number" name="price" value="" /><br>
            <input type="submit" value="CREATE" />
        </form>
    </body>
</html>
