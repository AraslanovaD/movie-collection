package movie.collection.service;

import movie.collection.entity.Actor;
import movie.collection.exception.NoSuchDataException;
import movie.collection.repository.ActorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    private ActorRepository repository;

    private final Logger logger = LoggerFactory.getLogger(ActorServiceImpl.class);

    @Override
    public List<Actor> getAll() {
        return repository.findAll();
    }

    @Override
    public Actor get(int id) {
        return repository.findById(id).orElseThrow(()->new NoSuchDataException("There is no actor with id="+id));
    }

    @Override
    public Actor save(Actor actor) {
        logger.info("Saving actor = {}", actor);
        return repository.save(actor);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }


}
