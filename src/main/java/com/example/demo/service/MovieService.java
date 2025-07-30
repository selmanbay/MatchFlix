package com.example.demo.service;
import com.example.demo.model.Movie;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final List<Movie> movies = new ArrayList<>();

    public List<Movie> getAllMovies() {
        return movies;
    }
    public void addMovie(Movie movie) {
        movies.add(movie);
        System.out.println("Film eklendi: " + movie.getTitle());
    }
}

