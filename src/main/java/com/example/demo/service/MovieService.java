package com.example.demo.service;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}

