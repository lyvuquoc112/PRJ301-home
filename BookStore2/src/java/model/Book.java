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
    private int bookID;
    private String tittle, publishedDate, category;
    private double price;

    public Book() {
    }

    public Book(int bookID, String tittle, String publishedDate, String category, double price) {
        this.bookID = bookID;
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
    
    

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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

    public void setCategory(String Category) {
        this.category = Category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "bookID=" + bookID + ", tittle=" + tittle + ", publishedDate=" + publishedDate + ", Category=" + category + ", price=" + price + '}';
    }
    
    
}

