package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Ana sayfa
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "index";
    }

    // Film ekleme
    @PostMapping("/add")
    public String addMovie(@RequestParam String title) {
        movieService.addMovie(new Movie(title));
        return "redirect:/";
    }

    // Autocomplete için film önerileri
    @GetMapping("/suggest")
    @ResponseBody
    public List<String> suggestMovies(@RequestParam String query) {
        return movieService.getAllMovies().stream()
                .map(Movie::getTitle)
                .filter(title -> title.toLowerCase().contains(query.toLowerCase()))
                .limit(5)
                .toList();
    }
}
