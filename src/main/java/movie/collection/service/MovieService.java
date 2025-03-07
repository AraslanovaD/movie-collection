package movie.collection.service;

import movie.collection.entity.Genre;
import movie.collection.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    Movie get(int id);
    Movie save(Movie movie);
    void delete(int id);

    Movie addGenre(int id, Genre genre);
    void removeGenre(int id, int genreId);
}
