package movie.collection.dto;

import movie.collection.entity.Genre;
import movie.collection.entity.Movie;

import java.time.LocalDate;
import java.util.Set;

public class MovieDTO {
    private int id;
    private String title;
    private LocalDate release;
    private Set<Genre> genres;

    public MovieDTO() {
    }

    public MovieDTO(Movie movie){
        this.id= movie.getId();
        this.title= movie.getTitle();
        this.release=movie.getRelease();
        this.genres=movie.getGenres();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
