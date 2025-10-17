/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.huylvq.shop.watcher.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hanly chỉ filter trang có địa chỉ url là watch.html ví dụ là nếu muốn
 * vào trang htmml, thì sẽ yêu cầu đăng nhập trước
 * AuthFilter là dùng để chặn user truy cập những trang mà cần yêu cầu gì đó ví
 * dụ là bỏ đò vào vỏ hàng
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/watch.html"})
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("account") == null) {//session ko đang tồn tại 
            req.setAttribute("error", "vui lòng đăng nhập trước khi xem watch.html!!!");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(req, res);
            return;
        }
        chain.doFilter(request, response);
    }

}
