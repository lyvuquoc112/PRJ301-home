/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author hanly
 */
public class BookDAO{
    private final String GET_BOOK_SQL = "";
    private final String GET_BOOK_SQL_BY_ID = "";
    private final String CREATE_BOOK = "";
    private final String DELETE_BOOK_BY_ID = "";
    private final String UPDATE_BOOK_BY_ID = "";
    
    public Book getBookByID(){
        try {
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Book> getAllBook(){
       
        try {
            
            }
        } catch (Exception e) {
             e.printStackTrace(); // tạm thời để thấy lỗi nếu DB có vấn đề
        }
        
    }
    
    public boolean removeBookById(int bookID){
        try {
            
            }
        } catch (Exception e) {
        }
        
    }
    
    private LocalDate parseDate(String date) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            return LocalDate.parse(date, dtf);
        } catch (Exception e) {
            try {
                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return LocalDate.parse(date, dtf1);
            } catch (Exception e1) {
                try {
                    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                    return LocalDate.parse(date, dtf2);
                } catch (Exception e2) {
                }
            }
        }
        return null;
    }
    
    public void addNewBook(){
        try {
            
        } catch (Exception e) {
        }
    }
    
    public void updateBookByID(){
        try {
           
        } catch (Exception e) {
        }
    }
}
