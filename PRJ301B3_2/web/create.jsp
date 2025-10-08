<%-- 
    Document   : create
    Created on : Sep 23, 2025, 9:32:40 AM
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
        <h1>Add New Student</h1>
        <form method = "POST" action="main">
            Full Name: <input type="text" name="fullname" value="" /> <br>
             DOB: <input type="date" name="dob" value="" /> <br>
            Gender: <input type="text" name="gender" value="" /><br>
           
            Email: <input type="text" name="email" value="" /><br>
            Phone: <input type="text" name="phone" value="" /><br>
            <input type="submit" value="CREATE" />
        </form>

    </body>
</html>
