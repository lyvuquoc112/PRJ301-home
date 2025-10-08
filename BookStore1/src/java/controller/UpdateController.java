/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;

/**
 *
 * @author hanly
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/update"})
public class UpdateController extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        BookDAO dao = new BookDAO();
        Book newBook = dao.getBookByID(bookId);
        
        request.setAttribute("newBook", newBook);
        request.getRequestDispatcher("update.jsp").forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String tittle = request.getParameter("tittle");
        String publishedDate = request.getParameter("publishedDate");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        
        Book book = new Book(bookId, tittle, publishedDate, category, price);
        
        BookDAO dao = new BookDAO();
        dao.updateBookByID(book);
        
        response.sendRedirect("main");
    }

}
