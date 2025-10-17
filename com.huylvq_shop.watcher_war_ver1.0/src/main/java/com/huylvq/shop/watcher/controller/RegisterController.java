/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.huylvq.shop.watcher.controller;

import com.huylvq.shop.watcher.dao.AccountDAO;
import com.huylvq.shop.watcher.model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author hanly
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private final AccountDAO dao = new AccountDAO();
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String submit = request.getParameter("submit");
        
        //B1. Kiem tra xem username co ton tai chua
        // - neu ton tai roi thi keu nguoi dung dang ky username khac
        // - neu chua ton tai thi dang ky cho nguoi dung       
        if(dao.findByUsername(username)!=null){
            request.setAttribute("error", "Username existed");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        Account acc = new Account();
        acc.setEmail(email);
        acc.setUsername(username);
        
        String pwdHash = BCrypt.hashpw(password, BCrypt.gensalt()); // cau lenh giup ma hoa password
        // gensalt la tao ngau nhien phan salt
        acc.setPassword(pwdHash);
        
        dao.create(acc);
        
        response.sendRedirect("login.jsp");
    }

    

}
