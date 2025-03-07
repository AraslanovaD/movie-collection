package movie.collection.controller;

import jakarta.validation.Valid;
import movie.collection.dto.ActorDTO;
import movie.collection.dto.MovieDTO;
import movie.collection.entity.Actor;
import movie.collection.entity.Movie;
import movie.collection.entity.Role;
import movie.collection.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorRestController {
    @Autowired
    private ActorService service;

    @GetMapping("")
    public List<ActorDTO> getAllActors(){
        List<Actor> actors = service.getAll();

        List<ActorDTO> actorDTO = actors
                .stream()
                .map(ActorDTO::new)
                .toList();

        return actorDTO;
    }

    @GetMapping("/{id}")
    public ActorDTO getActorById(@PathVariable("id") int id){
        Actor actor = service.get(id);

        return new ActorDTO(actor);
    }

    @GetMapping("/{id}/movies")
    public List<MovieDTO> getRoles(@PathVariable("id") int id){
        Actor actor = service.get(id);

        List<Movie> movies = actor.getRoles().stream().map(Role::getMovie).toList();

        List<MovieDTO> movieDTO = movies.stream().map(MovieDTO::new).toList();

        return movieDTO;
    }

    @PostMapping("")
    public ResponseEntity<ActorDTO> addNewActor(@RequestBody @Valid Actor actor){
        Actor createdActor = service.save(actor);
        return new ResponseEntity<>(new ActorDTO(createdActor), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<ActorDTO> updateActor(@RequestBody @Valid Actor actor){
        Actor updatedActor = service.save(actor);
        return new ResponseEntity<>(new ActorDTO(updatedActor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable("id")int id){
        service.get(id);

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
