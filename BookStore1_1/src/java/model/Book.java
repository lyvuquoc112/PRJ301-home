/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hanly
 */
public class Book {
    private int bookId;
    private String tittle;
    private String publishedDate;
    private String category;
    private double price;

    public Book() {
    }

    public Book(int bookId, String tittle, String publishedDate, String category, double price) {
        this.bookId = bookId;
        this.tittle = tittle;
        this.publishedDate = publishedDate;
        this.category = category;
        this.price = price;
    }

    public Book(String tittle, String publishedDate, String category, double price) {
        this.tittle = tittle;
        this.publishedDate = publishedDate;
        this.category = category;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", tittle=" + tittle + ", publishedDate=" + publishedDate + ", category=" + category + ", price=" + price + '}';
    }
    
    
}
