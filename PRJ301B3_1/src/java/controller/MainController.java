
package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;


@WebServlet(name = "MainController", urlPatterns = {"/main"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student std = new Student("1", "Huy", "A", "A", "A", "A");
        request.setAttribute("std", std); //std được bỏ vào cái hộp, ghi tên là "std"
        request.getRequestDispatcher("index.jsp").forward(request, response); // cái hộp được ghi 
        // đích đến, và gửi đi
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
 
}
