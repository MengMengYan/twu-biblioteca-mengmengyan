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
        Menu menu = new Menu();
        System.out.println(menu.welcomeUser());
        Command command = new MenuCommand();
        System.out.println(command.execute(null));

        Inventory inventory = initializeInventory();
        Scanner in = new Scanner(System.in);

        while (continueRunning) {
            String input = getStringInput(in);

            command = create(input);

            if (command.getClass().equals(QuitCommand.class)) {
                continueRunning = false;
            }
            System.out.println(command.execute(inventory));
        }
    }

    static Command create(String input) {
        if (input.equals("Quit")) {
            return new QuitCommand();
        } else if (input.equals("List Books")) {
            return new ListBookCommand();
        } else {
            return new MenuCommand();
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
        return in.nextLine().trim();
    }
}
