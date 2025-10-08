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
import java.util.List;
import model.Book;

/**
 *
 * @author hanly
 */
@WebServlet(name = "MainController", urlPatterns = {"/main"})
public class MainController extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookDAO dao = new BookDAO();
        List<Book> listBK = dao.getAllBook();
        
        request.setAttribute("listBK", listBK);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String tittle = request.getParameter("tittle");
            String publishedDate = request.getParameter("publishedDate");
            String category = request.getParameter("category");
            Double price = Double.parseDouble(request.getParameter("price"));
            BookDAO dao = new BookDAO();
            Book book  = new Book(tittle, publishedDate, category, price);
            dao.addNewBook(book);
            
            response.sendRedirect("main");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
