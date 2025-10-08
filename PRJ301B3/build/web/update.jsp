<%-- 
    Document   : update
    Created on : Sep 23, 2025, 12:13:30 PM
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
        <h1>Update Student</h1>
        <form method = "POST" action="update">
           <input type="hidden" name="studentId" value="${requestScope.std.studentId}" />
            Full Name: <input type="text" name="fullname" value="${requestScope.std.fullName}" /> <br>
            DOB: <input type="date" name="dob" value="${requestScope.std.dob}" /> <br>
            Gender: <input type="text" name="gender" value="${requestScope.std.gender}" /><br>
           
            Email: <input type="text" name="email" value="${requestScope.std.email}" /><br>
            Phone: <input type="text" name="phone" value="${requestScope.std.phone}" /><br>
            <input type="submit" value="UPDATE" />
        </form>

    </body>
</html>
