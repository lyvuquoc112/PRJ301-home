package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDAO extends DBContext {
    // Task 1: Lấy dữ liệu từ database lên hiển thị

    // B1: tạo ra 1 câu lệnh thực hiện chức năng mong muốn
    private final String GET_STUDENT_SQL = "select * from Student";
    private final String REMOVE_STUDENT_BY_ID ="DELETE FROM [dbo].[Student]\n" +
                                                "WHERE StudentID=?";

    // B2: Tạo hàm để tiến hành chạy câu lệnh SQL vừa tạo và lấy kết quả
    public List<Student> getListStudent() {
        List<Student> res = new ArrayList<>();
        try {
            PreparedStatement pst = c.prepareStatement(GET_STUDENT_SQL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Student std = new Student(rs.getString("StudentID"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("DOB"),
                        rs.getNString("Email"),
                        rs.getString("Phone"));
                res.add(std);
            }
        } catch (Exception e) {
            return null;
        }
        return res;
    }
    public boolean removesStudentById(String studentID){
        try {
            PreparedStatement pst = c.prepareStatement(REMOVE_STUDENT_BY_ID);
            pst.setString(1, studentID);
            int res = pst.executeUpdate();
            if(res!=0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    
    
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.removesStudentById("1");
        for (Student student : dao.getListStudent()) {
            System.out.println(student);
        }
    }
}
