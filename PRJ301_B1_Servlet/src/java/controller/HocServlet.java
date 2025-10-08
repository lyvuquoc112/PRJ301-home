package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HocServlet", urlPatterns = {"/hoc"}) // web.xml
public class HocServlet extends HttpServlet {

    //BT 1: nếu nhập là admin --> Hello Quan Tri Vien
    //                  non-admin --> Không có quyền truy cập
    //BT 2: Form đăng nhập --> Username - Password
    //Đúng -> chào mừng bạn
    // sai -> tạp biệt
    //Luyện tập: Máy tính cộng trừ
    // Mục tiêu:
    // Flow: Nhập 2 số -> chọn phép tính -> xử lí kết quả -> trả về
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
        // PrintWriter là một lớp dùng để ghi dữ liệu dưới dạng text
        // bởi vì muốn in ra phản hồi nên phải dùng response và get là trả về
        // printwriter
//        out.println("Hello World");

        //// BT 1
//        String name = request.getParameter("ten"); // đưa ra giá trị của parameter ten
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//        if(name.equalsIgnoreCase("admin")){
//            out.println("Hello Quan Tri Vien!!!");
//        }else{
//            out.println("Ban khong phai la quan tri vien, khong co quyen truy cap!!!");
//        }
        //Luyện tập
        String num1_raw = request.getParameter("num1");
        String num2_raw = request.getParameter("num2");
        String phepTinh = request.getParameter("pheptinh");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            int num1 = Integer.parseInt(num1_raw); // nếu không phải là số, thì dùng exception
            int num2 = Integer.parseInt(num2_raw);

            out.print("Kết quả là: ");

            if (phepTinh.equals("cong")) {
                out.print(num1 + num2);
            } else {
                out.print(num1 - num2);
            }
        } catch (Exception e) {
            out.print("Nhập đúng dữ liệu dùm");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // do post nó sẽ không hiện para trên đường link
        // BT 2
//        String username = request.getParameter("username"); 
//        String password = request.getParameter("password");
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//        if(username.equals("admin") && password.equals("123")){
//            out.println("Hello!!!");
//        }else{
//            out.println("GoodBye!!!");
//        }
    }

    // GET,POST, PUT, DELETE
    // GET - POST
    // PUT: Upadate data
    // DELETE: Delete data
}
