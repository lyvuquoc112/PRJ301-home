<%-- 
    Document   : index
    Created on : Sep 4, 2025, 3:19:48 PM
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




        <h1>Máy tính cộng trừ nhân chia</h1>

        <form>
            Num1: <input type="text" name="num1" value="" /> <br>
            Num2: <input type="text" name="num2" value="" /> <br>
            Phép tính: <select name="phepTinh">
                <option value="+">Cộng</option>
                <option value="-">Trừ</option>
                <option value="*">Nhân</option>
                <option value="/">Chia</option>
            </select> <br>
            <input type="submit" value="CALCULATE" />
        </form>
        <%
            String n1_raw = request.getParameter("num1");
            String n2_raw = request.getParameter("num2");
            String phepTinh = request.getParameter("phepTinh");
            double result = 0;
            String error = "";
            try {
                double n1 = Double.parseDouble(n1_raw);
                double n2 = Double.parseDouble(n2_raw);

                switch (phepTinh) {
                    case "+":
                        result = n1 + n2;
                        break;
                    case "-":
                        result = n1 - n2;
                        break;
                    case "*":
                        result = n1 * n2;
                        break;
                    case "/":
                        if (n2 != 0) {
                            result = n1 / n2;
                        } else {
                            error = "Vui lòng nhập n2 là một số khác không!!!";
                        }
                        break;
                }
            } catch (Exception e) {
            }
        %>
        <% if (error.equals("") == false) {%>
        <%= error%>
        <%}%>

        <% if (result != 0) {%>
        <%= result%>
        <%}%>

    </body>
</html>
