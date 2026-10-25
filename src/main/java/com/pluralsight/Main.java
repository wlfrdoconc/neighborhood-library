package com.pluralsight;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Requirements in main

        // 1. Home Screen with three options the user can choose from:
        // Show Available Books (Type 1 to show)
        // Show Checked Out Books (Type 2 to show)
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

        // Entry point
        System.out.println("====================================");
        System.out.println("WELCOME TO THE NEIGHBORHOOD LIBRARY!");
        System.out.println("====================================");

        // Array of 20 books
        Book[] inventory = {
                new Book(1, "9781234567897", "One Piece"),
                new Book(2, "9782345678901", "Harry Potter"),
                new Book(3, "9783456789012", "Black Clover"),
                new Book(4, "9784567890123", "The Odyssey"),
                new Book(5, "9785678901234", "The Catcher in the Rye"),
                new Book(6, "9786789012345", "Magi"),
                new Book(7, "9787890123456", "Blank Canvas"),
                new Book(8, "9788901234567", "Berserk"),
                new Book(9, "9789012345678", "Vagabond"),
                new Book(10, "9780123456789", "Kingdom"),
                new Book(11, "9781122334455", "ReLife"),
                new Book(12, "9782233445566", "Hunter x Hunter"),
                new Book(13, "9783344556677", "The Great Gatsby"),
                new Book(14, "9784455667788", "The Boxer"),
                new Book(15, "9785566778899", "Fragrant Flower"),
                new Book(16, "9786677889900", "To Kill a Mocking Bird"),
                new Book(17, "9787788990011", "1984"),
                new Book(18, "9788899001122", "Land of the Lustrous"),
                new Book(19, "9789900112233", "Tokyo Ghoul"),
                new Book(20, "9781011121314", "Slam Dunk")
        };

        Scanner read = new Scanner(System.in);

        // While the currentChoice is empty, run the program
        String currentChoice = "";

        // Display the menu
        // While loop that navigates through the program
        while(!currentChoice.equalsIgnoreCase("X")) {
            displayMenuOptions();
            currentChoice = read.nextLine();

            switch (currentChoice) {
                case "1":
                    System.out.println("Show available books TEST");

                    // Method to display current available books
                    showAvailableBooks(inventory);
                    break;
                case "2":
                    System.out.println("Show currently checked out books TEST");

                    // Method to display checked out books
                    showCheckedOutBooks(inventory);
                    break;
                case "X":
                    System.out.println("See you later! TEST");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        // End of main()
    }


    // Methods
    // 1. Create a menu method to display the choices the user can navigate the program with
    // 2. Create a method that shows the available books in the library
    // 3. Create a method that shows the currently checked out books
    // 4. Create a method to check in a book

    // 1. Menu method: displayMenuOptions() method
    public static void displayMenuOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1. Show current available books");
        System.out.println("2. Show the books that have been checked out");
        System.out.println("X. Exit the program");
        System.out.print("Enter your choice to proceed (1, 2, X): ");
    }

    // 2. Show available books: showAvailableBooks()
    public static void showAvailableBooks(Book[] inventory) {
        // Loop through every object in the array
        // Check whether each book is checked out
        // If the book is not checked out, display its ID, ISBN, and title

        System.out.println("=== AVAILABLE BOOKS ===");

        // Use an enhanced for loop to iterate through the array of books
        for (Book book: inventory) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId()
                        + " | ISBN: " + book.getIsbn()
                        + " | Title: " + book.getTitle());
                System.out.println();
            }
        }

        // Prompt the user to select a book to check out, or exit back to the home screen
        System.out.println("Would you like to check out a book? Select X to continue, otherwise press X: ");


    }

    // 3. Show current checked out books: showCheckedOutBooks()
    public static void showCheckedOutBooks(Book[] inventory) {
        for (Book book: inventory) {
            if(book.isCheckedOut()) {
                System.out.print("ID: " + book.getId());
                System.out.print("ISBN: " + book.getIsbn());
                System.out.print(("Title: " + book.getTitle()));
                System.out.println();
            }
        }
    }

    // 4. Check out a book: checkBookOut()
    public static void checkBookOut(Book[] inventory, Scanner read) {

        // Prompt the user to select a book to check out, or exit back to the home screen
        System.out.print("Select a book to check out from its ID number, if not press 0 to exit: ");
        int bookId = read.nextInt();
        read.nextLine();

        // If the entered bookId is 0, exit the program
        if (bookId == 0) {
            return;
        }

        System.out.println();

        // Enhanced for loop that goes through the current inventory of books
        for (Book book: inventory) {
            if (book.getId() == bookId) { // Checks if the entered ID matches any of the IDs in the inventory
                if (!book.isCheckedOut()) { // If the book is available, ask the user for their name
                    System.out.print("Please enter your name to reserve the book: ");
                    String enteredName = read.nextLine();

                    // Checks out the book
                    book.checkOut(enteredName); // Uses checkOut() from the Book class

                    System.out.println("The book has been successfully checked out!");
                }
                else {
                    System.out.println("This book is already checked out.");
                }
                return;
            }
        }

        // If the user enters an ID that doesn't match, print error message
        System.out.println("The entered ID doesn't match any books in our library");
    }

    // 5. Check in a book: checkBookIn()
    public static void checkBookIn(Book[] inventory, Scanner read) {

    }


}