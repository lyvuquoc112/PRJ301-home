<%-- 
    Document   : index
    Created on : Sep 4, 2025, 2:17:39 PM
    Author     : hanly
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  <!-- Directive (bộ mã 
                                                        hóa là UTF-8, nội dùng
                                                        là text/html) -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        
        
        <!-- Tạo 1 form đăng nhập
        Nếu như mà đăng nhập sai -> hiện kết quả fail trên chính form đăng nhập
        Nếu như mà thành công -> thì nhảy sang 1 trang khác
        -->
        
        <%
            String msg = (String)request.getAttribute("msg"); // xem tên của gói được chuyển đi
        %>
        
        
        
        
        <form action="login" method="POST">
            Username:<input type="text" name="username" value="" /> <br>
            Password<input type="text" name="password" value="" /> <br>
            <input type="submit" value="LOGIN" />
        </form>
        <% if(msg!=null){%>
            <%= msg %>
        <%}%>
        
    </body>
</html>
