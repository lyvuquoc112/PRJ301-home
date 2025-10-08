<%-- 
    Document   : update
    Created on : Sep 23, 2025, 4:30:28 PM
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
        <h1>Update Book</h1>
        <form method = "POST" action="update">
            <input type="hidden" name="bookId" value="${requestScope.newBook.bookId}" />
            Tittle: <input type="text" name="tittle" value="${requestScope.newBook.tittle}" /> <br>
            Published Date: <input type="date" name="publishedDate" value="${requestScope.newBook.publishedDate}" /> <br>
            Category <input type="text" name="category" value="${requestScope.newBook.category}" /><br>
            Price: <input type="number" name="price" value="${requestScope.newBook.price}" /><br>
            <input type="submit" value="UPDATE" />
        </form>
    </body>
</html>
