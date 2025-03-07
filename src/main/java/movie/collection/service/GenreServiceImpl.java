package movie.collection.service;

import movie.collection.entity.Genre;
import movie.collection.exception.NoSuchDataException;
import movie.collection.repository.GenreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository repository;

    private final Logger logger = LoggerFactory.getLogger(GenreServiceImpl.class);

    @Override
    public List<Genre> getAll() {
        return repository.findAll();
    }

    @Override
    public Genre get(int id) {
        return repository.findById(id).orElseThrow(()->new NoSuchDataException("There is no genre with id="+id));
    }

    @Override
    public Genre save(Genre genre) {
       logger.info("Saving genre = {}", genre);
       return repository.save(genre);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
