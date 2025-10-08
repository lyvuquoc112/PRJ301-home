<%-- 
    Document   : create
    Created on : Sep 24, 2025, 3:39:04 PM
    Author     : hanly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Book</title>
    </head>
    <body>
        <h1>Create New Book</h1>
        <form action="main" method="POST">
            Tittle: <input type="text" name="tittle" value="" /> <br>
            Published Date:<input type="date" name="publishedDate" value="" /><br>
            Category:<input type="text" name="category" value="" /><br>
            Price: <input type="text" name="price" value="" /><br>
            <input type="submit" value="CREATE" /><br>
        </form>
    </body>
</html>
