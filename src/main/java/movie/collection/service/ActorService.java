package movie.collection.service;


import movie.collection.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getAll();
    Actor get(int id);
    Actor save(Actor actor);
    void delete(int id);
}
