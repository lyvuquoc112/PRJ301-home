package controller;

import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Student;

@WebServlet(name = "MainController", urlPatterns = {"/main"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO dao = new StudentDAO();
        List<Student> listStd = dao.getListStudent();

        Student std = new Student(1, "Huy", "A", "A", "A", "A");
        request.setAttribute("listStd", listStd); //std được bỏ vào cái hộp, ghi tên là "std"
        request.getRequestDispatcher("index.jsp").forward(request, response); // cái hộp được ghi 
        // đích đến, và gửi đi

        // khi dùng request thì đường dẫn không thay đổi, nhưng giao diện hiện lên lại là đường 
        // dẫn nó chỉ đến 
        // dùng khi cần gửi dữ liệu đến trang đích
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        StudentDAO dao = new StudentDAO();
        dao.addNewStudent(new Student(fullName, gender, dob, email, phone));
        response.sendRedirect("main");
        // không dùng request bởi vì request sẽ gọi lại main, main lại tiếp tục gọi request
        // lặp vô tận khiến overstack
        // còn response thì chỉ gọi đến main thôi
        // trở về một trang bất kỳ có thay đổi đường dẫn
        // dùng khi không cần gửi dữ liệu
    }

}
