<%-- 
    Document   : index
    Created on : Sep 23, 2025, 4:30:15 PM
    Author     : hanly
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="create.jsp">Add More Book</a>
        <table border="1">
            <thead>
                <tr>
                    <th>BookID</th>
                    <th>Tittle</th>
                    <th>PublishedDate</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach var="i" items="${requestScope.listBK}">
                  <tr>
                    <td>${i.bookId}</td>
                    <td>${i.tittle}</td>
                    <td>${i.publishedDate}</td>
                    <td>${i.category}</td>
                    <td>${i.price}</td>
                    <td>
                        <a href="update?bookId=${i.bookId}">Update</a>
                         <a href="remove?bookId=${i.bookId}">Remove</a>
                    </td>
                </tr>   
                </c:forEach>
               
            </tbody>
        </table>

    </body>
</html>
