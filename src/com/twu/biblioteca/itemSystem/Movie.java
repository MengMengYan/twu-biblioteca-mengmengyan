package com.twu.biblioteca.itemSystem;

public class Movie {
    private String title;
    private int year;
    private String director;
    private String rating;

    public Movie(String title, int year, String director, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        if (rating >= 1 && rating <= 10) {
            this.rating = String.valueOf(rating);
        } else {
            this.rating = "unrated";
        }
    }

    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = "unrated";
    }

    public String getDetails() {
        return title + "\t|\t" + year + "\t|\t" + director + "\t|\t" + rating;
    }
}
