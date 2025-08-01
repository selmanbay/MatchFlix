package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
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

    // Film kaydetme
    @PostMapping("/save")
    public String saveMovie(@RequestParam String title, Model model) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movieService.addMovie(movie);
        model.addAttribute("message", "✅ Film başarıyla kaydedildi!");
        return "index";  // index.html tekrar açılır
    }

    // Film ekleme
    @PostMapping("/add")
    public String addMovie(@RequestParam String title) {
        Movie movie = new Movie();
        movie.setTitle(title);  // sadece title set ettik
        movieService.addMovie(movie);
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
