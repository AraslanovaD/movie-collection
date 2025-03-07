package movie.collection.service;

import movie.collection.entity.Genre;
import movie.collection.entity.Movie;
import movie.collection.exception.NoSuchDataException;
import movie.collection.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository repository;

    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Override
    public List<Movie> getAll() {
        return repository.findAll();
    }

    @Override
    public Movie get(int id) {
        return repository.findById(id).orElseThrow(()->new NoSuchDataException("There is no movie with id="+id));
    }

    @Override
    public Movie save(Movie movie) {
        logger.info("Saving movie = {}", movie);
        return repository.save(movie);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Movie addGenre(int id, Genre genre) {
        Movie movie = get(id);
        movie.addGenre(genre);

        logger.info("Adding genre = {} to movie = {}", genre, movie);

        return save(movie);
    }

    @Override
    public void removeGenre(int id, int genreId) {
        Movie movie = get(id);

        Genre genre = movie.getGenres().stream()
                .filter(g->g.getId()==genreId)
                .findFirst().orElse(null);

        movie.removeGenre(genre);

        save(movie);
    }

}
