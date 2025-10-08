

<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello world </title>
    </head>
    <body>
        
        EL: Expressiong Language & JSTL <br>
        <a href="create.jsp">Create New Student</a>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>FullName</th>
                    <th>Gender</th>
                    <th>DOB</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${requestScope.listStd}">
                <tr>
                    <td>${i.studentId}</td>
                    <td>${i.fullName}</td>
                    <td>${i.gender}</td>
                    <td>${i.dob}</td>
                    <td>${i.email}</td>
                    <td>${i.phone}</td>
                    
                    <td>
                        <a href="update?studentId=${i.studentId}">Update</a> <br>
                        <a href="remove?studentId=${i.studentId}">Remove</a>
                        <!-- remove sẽ truyền thêm studentID = 1 -->
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>    
        <c:forEach var="i" items="${requestScope.listStd}">
            ${i.toString()} <br>
        </c:forEach>
                
    </body>
</html>
