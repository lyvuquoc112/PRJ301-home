<%-- 
    Document   : index
    Created on : Sep 24, 2025, 2:37:10 PM
    Author     : hanly
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <a href="create.jsp">Click here to create new book</a>
        <table border="1">
            <thead>
                <tr>
                    <th>BookID</th>
                    <th>Tittle</th>
                    <th>PublishedDate</th>
                    <th>Category</th>
                    <th>Price</th
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${requestScope.listBK}">
                    <tr>
                        <td>${i.bookID}</td>
                        <td>${i.tittle}</td>
                        <td>${i.publishedDate}</td>
                        <td>${i.category}</td>
                        <td>${i.price}</td>
                        <td>
                            <a href="update?bookID=${i.bookID}">Update</a>
                            <a href="remove?bookID=${i.bookID}">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
