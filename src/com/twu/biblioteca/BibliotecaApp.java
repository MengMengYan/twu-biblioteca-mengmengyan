package com.twu.biblioteca;

import com.twu.biblioteca.bookSystem.Book;
import com.twu.biblioteca.bookSystem.Inventory;
import com.twu.biblioteca.navigation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
        boolean continueRunning = true;
        Command command = new WelcomeCommand();
        System.out.println(command.execute(null, null));
        command = new MenuCommand();
        System.out.println(command.execute(null, null));

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
        return new Inventory(books);
    }

    private static String getStringInput(Scanner in) {
        return in.nextLine().trim().toLowerCase();
    }
}
