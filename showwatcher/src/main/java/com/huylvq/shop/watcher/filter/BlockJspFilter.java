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
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hanly this filter block every domain name have .jsp => all url need
 * to be checked (* mean all)
 * ngăn chặn truy cập tất cả các trang .jsp
 */
@WebFilter(filterName = "BlockJspFilter", urlPatterns = {"/*"}) // urlPatterns "/*" cho phep thang chay duong dan do
public class BlockJspFilter implements Filter {
    // Servlet Request is parent of HttpRequest, SMTP request, TCP Request
    // nhận hết các loại request đến từ mọi loại giao thức
//để tránh th có 1 thằng request đến từ 1 giao thức mạng khác http xâm nhập trái phép

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI(); // trả về đường dẫn request người dùng gửi đến
        if (uri != null && uri.endsWith(".jsp")) {
            res.sendRedirect("index.html");
            return;
        }

        chain.doFilter(request, response); // nếu người dùng tuân thủ, không truy cập vào đường dẫn jsp thì sẽ bỏ qua doFilter
    }

}
