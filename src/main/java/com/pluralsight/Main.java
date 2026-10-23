package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Requirements in main

        // 1. Home Screen with three options the user can choose from:
        // Show Available Books
        // Show Checked Out Books
        // Exit - closes the application

        // 2. Show available books
        // List all books that are not checked out
        // Show the id, ISBN, and title

        // 3. Show checked out books
        // List all books that are checked out
        // Show the id, ISBN, title, and name of person who has it
        // Prompt the user: C - to check in a book, X - to go back to the home screen

        // 4. Check in a book
        // Prompt for the id of the check in, check it in and go back to the home screen

        // Array of 20 books
        Book[] inventoryStock = {
                new Book(1, "123456789", "One Piece"),
                new Book(2, "987654321", "Harry Potter"),
                new Book(3, "123789456", "Black Clover"),
                new Book(4, "789123456", "The Odyssey"),
                new Book(5, "456123789", "Walking Dead"),
                new Book(6, "456789123", "Magi"),
                new Book(7, "098765432", "Blank Canvas"),
                new Book(8, "234567890", "Berserk"),
                new Book(9, "345678901", "Vagabond"),
                new Book(10, "456789012", "Kingdom"),
                new Book(11, "567890123", "ReLife"),
                new Book(12, "111111111", "Hunter x Hunter"),
                new Book(13, "222222222", "The Great Gatsby"),
                new Book(14, "333333333", "The Boxer"),
                new Book(15, "444444444", "Fragrant Flower"),
                new Book(16, "555555555", "To Kill a Mocking Bird"),
                new Book(17, "678411111", "1984"),
                new Book(18, "789012345", "Land of the Lustrous"),
                new Book(19, "122233334", "Tokyo Ghoul"),
                new Book(20, "553423231", "Slam Dunk"),
        };


    }
}