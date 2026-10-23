package com.pluralsight;


public class Book {

    // Requirements in Book Class
    // 1. Create a book class with appropriate constructors, getters, setters and methods
    // 2. Create two methods void checkOut(String name) and void checkIn()
    // 3. Use an array to hold an inventory of at least 20 books
    // Those books should have a unique ID
    // 4. When a book is checked out: set checkedOutTo to the name provided and isCheckedOut to true
    // 5. When a book is checked in: set checkedOutTo to the "" and isCheckedOut to false


    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    // Constructors
    public Book() {

    }

    // Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckout() {
        return isCheckout;
    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    boolean isCheckout;
}
