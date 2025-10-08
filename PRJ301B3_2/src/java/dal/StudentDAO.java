package dal;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Student;


public class StudentDAO extends DBContext {
    // Task 1: Lấy dữ liệu từ database lên hiển thị

    // B1: tạo ra 1 câu lệnh thực hiện chức năng mong muốn
    private final String GET_STUDENT_SQL = "select * from Student";
    private final String GET_STUDENT_SQL_BY_ID = "select * from Student where StudentID=?";
    private final String REMOVE_STUDENT_BY_ID ="DELETE FROM [dbo].[Student]\n" +
                                                "WHERE StudentID=?";
    private final String UPDATE_STUDENT_BY_ID = "UPDATE [dbo].[Student]" +
                                                    " SET [FullName] =?" +
                                                    ",[Gender] =?" +
                                                    ",[DOB] =?" +
                                                    ",[Email] =?" +
                                                    ",[Phone] =?" +
                                                    " WHERE StudentID =? ";
    
    private final String ADD_STUDENT ="INSERT INTO [dbo].[Student]" +
                                        " ([FullName],[Gender],[DOB],[Email],[Phone])" +
                                        " VALUES (?,?,?,?,?)";
    public Student getstudentbyId(int studentId) {
        try {
            PreparedStatement pst = c.prepareStatement(GET_STUDENT_SQL_BY_ID);
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Student std = new Student(rs.getInt("StudentID"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("DOB"),
                        rs.getNString("Email"),
                        rs.getString("Phone"));
               return std;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    
    // B2: Tạo hàm để tiến hành chạy câu lệnh SQL vừa tạo và lấy kết quả
    public List<Student> getListStudent() {
        List<Student> res = new ArrayList<>();
        try {
            PreparedStatement pst = c.prepareStatement(GET_STUDENT_SQL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Student std = new Student(rs.getInt("StudentID"),
                        rs.getString("FullName"),
                       
                        rs.getString("Gender"),
                         rs.getString("DOB"),
                        rs.getNString("Email"),
                        rs.getString("Phone"));
                res.add(std);
            }
        } catch (Exception e) {
            e.printStackTrace();        }
        return res;
    }
    public boolean removesStudentById(int studentID){
        try {
            PreparedStatement pst = c.prepareStatement(REMOVE_STUDENT_BY_ID);
            pst.setInt(1, studentID);
            int res = pst.executeUpdate();
            if(res!=0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
   // ví dụ nhập dob là 16/02/2005  
    
   private LocalDate parseDate(String date){
    try {
        // Thử parse theo format MM/dd/yyyy trước
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(date, dtf1);
    } catch (Exception e1) {
        try {
            // Nếu không được thì parse theo format yyyy-MM-dd
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, dtf2);
        } catch (Exception e2) {
            // Nếu cả 2 đều không được thì throw exception
            throw new IllegalArgumentException("Invalid date format: " + date);
        }
    }
}
    
    
    // Làm hàm add
    public void addNewStudent(Student student) {
        try {
            PreparedStatement pst = c.prepareStatement(ADD_STUDENT);
            pst.setString(1, student.getFullName());
            pst.setString(2, student.getGender());
            Date dateSQL = Date.valueOf(parseDate(student.getDob()));
            pst.setDate(3, dateSQL); // muốn chuyển string thành date thì đầu tiên chuyển thành 
            // loccal đate sao đó mới lấy local date chuyển thành date
            
            pst.setString(4, student.getEmail());
            pst.setString(5, student.getPhone());
            
            int rows = pst.executeUpdate();
            System.out.println("[CREATE] OUT -> rows inserted = " + rows);
        } catch (Exception e) {
              e.printStackTrace();
              throw new RuntimeException(e);
        }
    }
    
    // Làm hàm update
    public void updateNewStudent(Student newStudent){
        try {
            PreparedStatement pst = c.prepareStatement(UPDATE_STUDENT_BY_ID);
            pst.setString(1, newStudent.getFullName());
            
           
            pst.setString(2, newStudent.getGender());
             Date dateSQL = Date.valueOf(parseDate(newStudent.getDob()));
            pst.setDate(3, dateSQL);
            pst.setString(4, newStudent.getEmail());
            pst.setString(5, newStudent.getPhone());
            pst.setInt(6, newStudent.getStudentId());
            int rows = pst.executeUpdate();
        System.out.println("Rows updated = " + rows + " for StudentID = " + newStudent.getStudentId());
        } catch (Exception e) {
            e.printStackTrace();
        throw new RuntimeException(e);
        }
    }

    
    
    
}
