
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String un = request.getParameter("username");
        String psw = request.getParameter("password");
        
        String unAdmin = "admin";
        String pswAdmin = "1234";
        if(un.equals(unAdmin) && psw.equals(pswAdmin)){
            String nameAdmin = "Huy";
            // đóng gối
            request.setAttribute("nAdmin", nameAdmin);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }else{
            // Các bước
            // 1. Đóng gối dữ liệu, ghi thông tin dữ liệu lên
            // 2. Vận chuyển dữ liệu, ghi địa chỉ từ nguồn đến đích
            String message = "Đăng nhập thất bại";
            request.setAttribute("msg", message); // đóng gói kết hợp ghi tên dữ liệu
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
    }

}
