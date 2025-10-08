/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hanly
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        
        String usernameSystem ="admin";
        String passwordSystem ="123";
        if(username.equals(usernameSystem) && password.equals(passwordSystem)){
            
            if(remember!=null){
                Cookie c = new Cookie("username", username);
                c.setMaxAge(60*60);
                // cookie bat buoc phai co thoi gian ton tai
                response.addCookie(c);
                // khi server response se di kem voi cookie
            }
            
            HttpSession session = request.getSession();
            // doi voi session khong can phai dat thoi gian ton tai
            session.setAttribute("username", username); // cap nhat tao 1 attribute 
            response.sendRedirect("home.jsp");
        }
    }

    

}
