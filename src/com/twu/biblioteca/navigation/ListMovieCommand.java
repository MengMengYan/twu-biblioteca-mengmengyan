package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Item;
import com.twu.biblioteca.roles.Role;

import java.util.Collection;

public class ListMovieCommand implements Command {
    @Override
    public String execute(Inventory inventory, String title, Role role) {
        Collection<Item> movies = inventory.getMovies();
        if (movies.isEmpty()) {
            return "No Movie available";
        }

        StringBuilder movieList = new StringBuilder();
        for (Item inventoryMovie : movies) {
            movieList.append(inventoryMovie.getDetails()).append("\n");
        }
        return movieList.toString().trim();
    }
}
