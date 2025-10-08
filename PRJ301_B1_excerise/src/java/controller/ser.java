package controller;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/process"})
public class ser extends HttpServlet {
    //Người dùng sẽ nhập Username và Password, 
    //hệ thống so sánh với tài khoản mẫu. 
    //Nếu khớp sẽ báo đăng nhập thành công, ngược lại báo thất bại.


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        if(userName.equals("admin") && passWord.equals("123")){
            out.print("Login Successfully!!!");
        }else{
            out.print("Login Failed!!");
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
  
}
