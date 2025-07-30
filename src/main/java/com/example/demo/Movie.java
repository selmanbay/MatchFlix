package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // Film adı
    private String genre;       // Tür (ör: Aksiyon, Drama)
    private int releaseYear;    // Çıkış yılı
    private String posterUrl;   // Afiş linki
    private double rating;      // IMDb veya TMDb puanı
    private String description; // Açıklama

    // Default constructor
    public Movie() {}

    // Constructor
    public Movie(String title, String genre, int releaseYear, String posterUrl, double rating, String description) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.description = description;
    }

    // Getter & Setter
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
