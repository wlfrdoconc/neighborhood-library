package com.pluralsight;


public class Book {

    // Requirements in Book Class
    // 1. Create a book class with appropriate constructors, getters, setters and methods
    // 2. Create two methods void checkOut(String name) and void checkIn()
    // 3. Use an array to hold an inventory of at least 20 books
    // Those books should have a unique ID
    // 4. When a book is checked out: set checkedOutTo to the name provided and isCheckedOut to true
    // 5. When a book is checked in: set checkedOutTo to the "" and isCheckedOut to false


    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructors

    // Parameterless
    public Book() {
        this.id = 0;
        this.isbn = "";
        this.title = "";
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Parameterized
    public Book(int id, String isbn, String title) {
       this.id = id;
       this.isbn = isbn;
       this.title = title;
       this.isCheckedOut = false;
       this.checkedOutTo = "";
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

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Methods

    // checkOut method to update setCheckOut to person's name and make isCheckedOut to true
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    // checkIn method to update the system when a user returns a book
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

}
