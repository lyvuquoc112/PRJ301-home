/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Book;
import java.sql.*;

/**
 *
 * @author hanly
 */
public class BookDAO extends DBContext{
    private final String GET_BOOK_SQL = "select * from books";
    private final String NEW_BOOK = "INSERT INTO [dbo].[books]" +
                                    "           ([Tittle]" +
                                    "           ,[PublishedDate]" +
                                    "           ,[Category]" +
                                    "           ,[Price])" +
                                    "     VALUES" +
                                    "           (?,?,?,?)";
    private final String REMOVE_BOOK_BY_ID = "DELETE FROM [dbo].[books] where BookID=?";
    private final String GET_BOOK_SQL_BY_ID = "select * from books where BookID=?";
    private final String UPDATE_BOOK_BY_ID = "UPDATE [dbo].[books]" +
                                                "   SET [Tittle] = ?" +
                                                "      ,[PublishedDate] = ?" +
                                                "      ,[Category] = ?" +
                                                "      ,[Price] = ?" +
                                                " WHERE BookID=?";
    
    public List<Book> getAllBook(){
        List<Book> res = new ArrayList<>();
        try {
            PreparedStatement pst = c.prepareStatement(GET_BOOK_SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("BookID"), rs.getString("Tittle"),
                        rs.getString("PublishedDate"), rs.getString("Category"), rs.getDouble("Price"));
                res.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public void addNewBook(Book book){
        try {
            PreparedStatement pst = c.prepareStatement(NEW_BOOK);
            pst.setString(1, book.getTittle());
            pst.setString(2, book.getPublishedDate());
            pst.setString(3, book.getCategory());
            pst.setDouble(4, book.getPrice());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean removeBookById(int bookID){
        try {
            PreparedStatement pst = c.prepareStatement(REMOVE_BOOK_BY_ID);
            pst.setInt(1, bookID);
            int rs = pst.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public Book getBook(int bookID){
        try {
            PreparedStatement pst = c.prepareStatement(GET_BOOK_SQL_BY_ID);
            pst.setInt(1, bookID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Book book = new Book(rs.getInt("BookID"), rs.getString("Tittle"),
                        rs.getString("PublishedDate"), rs.getString("Category"), rs.getDouble("Price"));
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
    public void updateBook(Book newBook) {
        try {
            PreparedStatement pst = c.prepareStatement(UPDATE_BOOK_BY_ID);
            pst.setString(1, newBook.getTittle());
            pst.setString(2, newBook.getPublishedDate());
            pst.setString(3, newBook.getCategory());
            pst.setDouble(4, newBook.getPrice());
            pst.setInt(5, newBook.getBookID());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
