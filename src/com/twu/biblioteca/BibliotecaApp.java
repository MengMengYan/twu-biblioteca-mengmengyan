package com.twu.biblioteca;

import com.twu.biblioteca.itemSystem.Book;
import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Movie;
import com.twu.biblioteca.navigation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
        boolean continueRunning = true;
        Command command = new WelcomeCommand();
        greetUser(command);

        Inventory inventory = initializeInventory();
        Scanner in = new Scanner(System.in);

        while (continueRunning) {
            String input = getStringInput(in);

            String possibleBookInput = checkForCheckinOrOut(input);

            command = create(input);

            if (command.getClass().equals(QuitCommand.class)) {
                continueRunning = false;
            }

            System.out.println(command.execute(inventory, possibleBookInput.trim()));
        }
    }

    private static void greetUser(Command command) {
        System.out.println(command.execute(null, null));
        command = new MenuCommand();
        System.out.println(command.execute(null, null));
    }

    static String checkForCheckinOrOut(String input) {
        if (input.contains("check")) {
            String[] singleInputs = input.split("\\s+");
            System.out.println(input);
            if (singleInputs.length > 1) {
                return singleInputs[1];
            }
        }
        return "";
    }

    static Command create(String input) {

        if (input.contains("quit")) {
            return new QuitCommand();
        } else if (input.contains("list books")) {
            return new ListBookCommand();
        } else if (input.contains("list movies")) {
            return new ListMovieCommand();
        } else if (input.contains("menu")) {
            return new MenuCommand();
        } else if (input.contains("checkout")) {
            return new CheckoutBookCommand();
        } else if (input.contains("checkin")) {
            return new CheckinBookCommand();
        } else {
            return new InvalidCommand();
        }
    }

    private static Inventory initializeInventory() {
        Map<String, Book> books = new HashMap<String, Book>();
        Book book1 = new Book("Title1", "Author1", 2042);
        Book book2 = new Book("Title2", "Author2", 1098);
        books.put("Title1", book1);
        books.put("Title2", book2);

        Map<String, Movie> movies = new HashMap<String, Movie>();
        return new Inventory(books, movies);
    }

    private static String getStringInput(Scanner in) {
        return in.nextLine().trim().toLowerCase();
    }
}
