/**
 * Workshop 2W: Neighborhood Library
 * 10/26/2026
 * @author Wilfredo Concepcion
 */

package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {

        // Project Requirements
        // 1. Display a home screen with options to view available books, checked out books, or exit
        // 2. Initialize an inventory of 20 books with unique IDs, ISBNs, and titles
        // 3. Show available books with their ID, ISBN, and title
        // 4. Allow users to check out a book by ID and enter their name, or return to the main menu
        // 5. Show checked out books with their ID, ISBN, title, and borrower's name
        // 6. Allow users to check in books by ID, handle invalid inputs, or return to the main menu

        // Entry point
        System.out.println("======== Welcome to the Neighborhood Library! ========");

        // Array of 20 books
        Book[] inventory = {
                new Book(1, "978-1-2345-6789-7", "One Piece"),
                new Book(2, "978-2-3456-7890-1", "Harry Potter"),
                new Book(3, "978-3-4567-8901-2", "Black Clover"),
                new Book(4, "978-4-5678-9012-3", "The Odyssey"),
                new Book(5, "978-5-6789-0123-4", "The Catcher in the Rye"),
                new Book(6, "978-6-7890-1234-5", "Magi"),
                new Book(7, "978-7-8901-2345-6", "Blank Canvas"),
                new Book(8, "978-8-9012-3456-7", "Berserk"),
                new Book(9, "978-9-0123-4567-8", "Vagabond"),
                new Book(10, "978-0-1234-5678-9", "Kingdom"),
                new Book(11, "978-1-1223-3445-5", "ReLife"),
                new Book(12, "978-2-2334-4556-6", "Hunter x Hunter"),
                new Book(13, "978-3-3445-5667-7", "The Great Gatsby"),
                new Book(14, "978-4-4556-6778-8", "The Boxer"),
                new Book(15, "978-5-5667-7889-9", "Fragrant Flower"),
                new Book(16, "978-6-6778-8990-0", "To Kill a Mocking Bird"),
                new Book(17, "978-7-7889-9001-1", "1984"),
                new Book(18, "978-8-8990-0112-2", "Land of the Lustrous"),
                new Book(19, "978-9-9001-1223-3", "Tokyo Ghoul"),
                new Book(20, "978-1-0111-2131-4", "Slam Dunk")
        };

        Scanner read = new Scanner(System.in);

        // Keeps the program running until the user exits
        String currentChoice = "";

        // Display the menu
        // While loop that navigates through the program
        while(!currentChoice.equalsIgnoreCase("X")) {
            displayMenuOptions();
            currentChoice = read.nextLine();

            switch (currentChoice.toUpperCase()) { // Used toUpperCase to ensure users can exit seamlessly
                case "1":
                    // Method to display current available books
                    showAvailableBooks(inventory);

                    // Method to check out a book
                    checkBookOut(inventory, read);
                    break;
                case "2":
                    // Method to display checked out books
                    showCheckedOutBooks(inventory);

                    // Prompt the user to check in a book or return to the home screen
                    String checkInChoice = "";

                    while (!checkInChoice.equalsIgnoreCase("X")) {
                        System.out.print("Press C to check in a book, or X to return: ");
                        checkInChoice = read.nextLine();

                        if (checkInChoice.equalsIgnoreCase("C")) {
                            checkBookIn(inventory, read);
                            break;
                        }
                        else if (!checkInChoice.equalsIgnoreCase("X")) {
                            System.out.println("Invalid choice! Please enter C or X.");
                        }
                    }
                    break;
                case "X":
                    System.out.println("See you later!");
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
        System.out.print("""

            ========== LIBRARY MAIN MENU ==========
            What would you like to do?
            1. Show available books
            2. Show checked out books
            X. Exit the program
            ---------------------------------------
            Enter your choice (1, 2, X):\s""");
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
            }
        }
    }

    // 3. Show current checked out books: showCheckedOutBooks()
    public static void showCheckedOutBooks(Book[] inventory) {
        System.out.println("=== CHECKED OUT BOOKS ===");

        for (Book book: inventory) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId()
                        + " | ISBN: " + book.getIsbn()
                        + " | Title: " + book.getTitle()
                        + " | Checked Out To: " + book.getCheckedOutTo());
            }
        }
    }

    // 4. Check out a book: checkBookOut()
    public static void checkBookOut(Book[] inventory, Scanner read) {

        // Prompt the user to select a book to check out, or exit back to the home screen
        System.out.print("Select a book to check out from its ID number, if not press 0 to exit: ");
        int bookId;

        // Try-catch exception that handles invalid book ID inputs
        try {
            bookId = Integer.parseInt(read.nextLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid book ID.");
            return;
        }

        // If the entered bookId is 0, return to the main menu
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
        System.out.println("The entered ID doesn't match any books in our library.");
    }

    // 5. Check in a book: checkBookIn()
    public static void checkBookIn(Book[] inventory, Scanner read) {

        // Prompt the user for the ID of the book they want to check in
        System.out.print("Enter the ID of the book you want to check in: ");
        int bookId;

        // Try catch exception to handle valid input formats
        try {
            bookId = Integer.parseInt(read.nextLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid book ID.");
            return;
        }

        // Check in the book with its specified id
        for (Book book: inventory) {
            if (book.getId() == bookId) {
                if (book.isCheckedOut()) { // Checks if the book is currently checked out
                    book.checkIn(); // If it is you can check it in
                    System.out.println("The book has been successfully checked in!");
                }
                else {
                    // Return a message if the book is already in the library
                    System.out.println("That book is already in our library.");
                }
                return;
            }
        }

        // If the user enters an ID that doesn't match, print error message
        System.out.println("The entered ID doesn't match any books in our library.");

    }
}