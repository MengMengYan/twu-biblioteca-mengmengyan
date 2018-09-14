package com.twu.biblioteca;

import com.twu.biblioteca.navigation.Command;
import com.twu.biblioteca.navigation.Menu;
import com.twu.biblioteca.navigation.QuitCommand;

import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
        boolean continueRunning = true;
        Menu menu = new Menu();
        System.out.println(menu.welcomeUser());
        Command command;

        while (continueRunning) {

            if (getStringInput().equals("Quit")) {
                continueRunning = false;
                command = new QuitCommand();
                System.out.println(command.execute());
            }
        }
    }

    private static String getStringInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim();
    }
}
