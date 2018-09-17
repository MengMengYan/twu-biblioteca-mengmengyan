package com.twu.biblioteca.navigation;

import com.twu.biblioteca.itemSystem.Inventory;
import com.twu.biblioteca.itemSystem.Movie;

import java.util.Collection;

public class ListMovieCommand implements Command {
    @Override
    public String execute(Inventory inventory, String book) {
        Collection<Movie> movies = inventory.getMovies();
        if (movies.isEmpty()) {
            return "No Movie available";
        }

        StringBuilder movieList = new StringBuilder();
        for (Movie inventoryMovie : movies) {
            movieList.append(inventoryMovie.getDetails()).append("\n");
        }
        return movieList.toString().trim();
    }
}
