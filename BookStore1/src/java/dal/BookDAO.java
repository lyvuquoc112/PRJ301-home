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
public class BookDAO extends DBContext{
    private final String GET_BOOK_SQL = "select * from books";
    private final String GET_BOOK_SQL_BY_ID = "select * from books where BookID=?";
    private final String CREATE_BOOK = "INSERT INTO [dbo].[books] "
                                        +" ([Tittle],[PublishedDate],[Category],[Price])"
                                        +" VALUES(?,?,?,?)";
    private final String DELETE_BOOK_BY_ID = "DELETE FROM [dbo].[books] where BookID =? ";
    private final String UPDATE_BOOK_BY_ID = "UPDATE [dbo].[books]"
                                            +" SET [Tittle] =?" +
                                            ",[PublishedDate] =?" +
                                            ",[Category] =?" +
                                            ",[Price] =?"+
                                            " WHERE BookID = ?";
    
    public Book getBookByID(int bookId){
        try {
            PreparedStatement pst = c.prepareStatement(GET_BOOK_SQL_BY_ID);
            pst.setInt(1,bookId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Book b = new Book(rs.getInt("BookID"),rs.getString("Tittle"),rs.getString("PublishedDate")
                                            ,rs.getString("Category"),rs.getDouble("Price"));
                return b;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Book> getAllBook(){
        List<Book> res = new ArrayList<>();
        try {
            PreparedStatement pst = c.prepareStatement(GET_BOOK_SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("BookID"),rs.getString("Tittle"),rs.getString("PublishedDate")
                                            ,rs.getString("Category"),rs.getDouble("Price"));
                res.add(book);
            }
        } catch (Exception e) {
             e.printStackTrace(); // tạm thời để thấy lỗi nếu DB có vấn đề
        }
        return res;
    }
    
    public boolean removeBookById(int bookID){
        try {
            PreparedStatement pst = c.prepareStatement(DELETE_BOOK_BY_ID);
            pst.setInt(1, bookID);
            int rs = pst.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
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
    
    public void addNewBook(Book book){
        try {
            PreparedStatement pst = c.prepareStatement(CREATE_BOOK);
            pst.setString(1, book.getTittle());
            pst.setString(2, book.getPublishedDate());
            pst.setString(3, book.getCategory());
            pst.setDouble(4, book.getPrice());
            pst.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void updateBookByID(Book newBook){
        try {
            PreparedStatement pst = c.prepareStatement(UPDATE_BOOK_BY_ID);
            pst.setString(1, newBook.getTittle());
            pst.setString(2, newBook.getPublishedDate());
            pst.setString(3, newBook.getCategory());
            pst.setDouble(4, newBook.getPrice());
            pst.setInt(5, newBook.getBookId());
            pst.executeUpdate();
        } catch (Exception e) {
        }
    }
}
