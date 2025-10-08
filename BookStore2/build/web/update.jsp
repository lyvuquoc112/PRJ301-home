<%-- 
    Document   : update
    Created on : Sep 24, 2025, 4:24:41 PM
    Author     : hanly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
       <h1>Update Book</h1>
        <form action="update" method="POST">
            <input type="hidden" name="bookID" value="${requestScope.newBook.bookID}" />
            Tittle: <input type="text" name="tittle" value="${requestScope.newBook.tittle}" /> <br>
            Published Date:<input type="date" name="publishedDate" value="${requestScope.newBook.publishedDate}" /><br>
            Category:<input type="text" name="category" value="${requestScope.newBook.category}" /><br>
            Price: <input type="text" name="price" value="${requestScope.newBook.price}" /><br>
            <input type="submit" value="UPDATE" /><br>
        </form>
    </body>
</html>
