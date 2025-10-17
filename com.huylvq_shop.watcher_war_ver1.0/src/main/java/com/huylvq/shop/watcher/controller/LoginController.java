
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
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
     private final AccountDAO dao = new AccountDAO();


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
// UI -> controller -> DAO -> Database
    
// User dang ky -> Password toi controller -> Brypt ma hoa password -> Luu ma hoa xuong DB
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Account acc = dao.findByUsername(username);
        if(acc!=null && BCrypt.checkpw(password, acc.getPassword())){ //getPassword la pwd da duoc ma hoa
            // cau lenh nay la de xem co tai khoan chua
            HttpSession session = request.getSession();
            session.setAttribute("account", acc);
            response.sendRedirect("index.jsp");
        }else{
            request.setAttribute("error", "Username or password is wrong. Try again!!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

   
   
}
