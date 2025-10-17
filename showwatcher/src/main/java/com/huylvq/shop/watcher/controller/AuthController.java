/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.huylvq.shop.watcher.controller;

import com.huylvq.shop.watcher.dao.AccountDAO;
import com.huylvq.shop.watcher.model.Account;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author hanly urlPatterns có thể viết theo dạng mảng
 */
@WebServlet(name = "AuthController", urlPatterns = {"/login", "/register"})
public class AuthController extends HttpServlet {

    private final AccountDAO dao = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("login")) {
            getLogin(request, response);
        } else if (uri.contains("register")) {
            getRegister(request, response);
        }
    }

    private void getLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
        //nếu ở chỗ này sử dụng sendReDirect thì đường dẫn sẽ có đuôi là  login.jsp. Nó sẽ bị Filter trả trở lại index.html
    }

    private void getRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("login")) {
            postLogin(request, response);
        } else if (uri.contains("register")) {
            postRegister(request, response);
        }
    }

    private void postLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        Account acc = dao.findByUsername(username);

        if (acc != null && BCrypt.checkpw(password, acc.getPassword())) { //getPassword la pwd da duoc ma hoa
            // cau lenh nay la de xem co tai khoan chua
            HttpSession session = request.getSession();
            session.setAttribute("account", acc);

            // remember me
            if (remember.equals("1")) { // số 1 có nghĩa là người dùng có tích vào ô remember me
                Cookie c = new Cookie("USERNAME_COOKIE", username);
                c.setMaxAge(7 * 60 * 60 * 24);
                response.addCookie(c);
            } else {//nếu người dùng không đánh dấu thì dev sẽ xóa đi Cookie
                    //để username_cookie là 1 chuỗi rỗng, thời gian tồn tại là không, add vào cookie
                Cookie c = new Cookie("USERNAME_COOKIE", "");
                c.setMaxAge(0);
                response.addCookie(c);
            }
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error", "Username or password is wrong. Try again!!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void postRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String submit = request.getParameter("submit");

        //B1. Kiem tra xem username co ton tai chua
        // - neu ton tai roi thi keu nguoi dung dang ky username khac
        // - neu chua ton tai thi dang ky cho nguoi dung       
        if (dao.findByUsername(username) != null) {
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
