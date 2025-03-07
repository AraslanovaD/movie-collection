package movie.collection.service;

import movie.collection.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();
    Genre get(int id);
    Genre save(Genre genre);
    void delete(int id);
}
