
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "Servlet", urlPatterns = {"/calculate"})
public class Servlet extends HttpServlet {

   
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String n1_raw = request.getParameter("num1");
       String n2_raw = request.getParameter("num2");
       String phepTinh = request.getParameter("phepTinh");
       double result = 0;
       String error ="";
        try {
            double n1 = Double.parseDouble(n1_raw);
            double n2 = Double.parseDouble(n2_raw);
            switch (phepTinh) {
                case "cộng":
                    result = n1+n2;
                    break;
                    case "trừ":
                    result = n1-n2;
                    break;
                    case "nhân":
                    result = n1*n2;
                    break;
                    case "chia":
                    if(n2!=0){
                    result = n1/n2;
                    }else{
                        error = "Vui lòng nhập n2 là một số khác không!!!";
                    }
                    break;    
            }
        } catch (Exception e) {
            error = "Vui lòng nhập số hợp lệ cho number 1 và number 2";
        }
        if(error.equals("")==false){
            request.setAttribute("msg",error);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            request.setAttribute("re",result);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
   
}
