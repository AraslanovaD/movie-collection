package movie.collection.controller;

import jakarta.validation.Valid;

import movie.collection.dto.ActorDTO;
import movie.collection.dto.GenreDTO;
import movie.collection.dto.MovieDTO;
import movie.collection.entity.Actor;
import movie.collection.entity.Genre;
import movie.collection.entity.Movie;
import movie.collection.entity.Role;
import movie.collection.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
    @Autowired
    private MovieService service;

    @GetMapping("")
    public List<MovieDTO> getAllMovies(){
        List<Movie> movies = service.getAll();

        List<MovieDTO> movieDTO = movies.stream().map(MovieDTO::new).toList();

        return movieDTO;
    }

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable("id") int id){
        Movie movie = service.get(id);

        return new MovieDTO(service.get(id));
    }

    @GetMapping("/{id}/actors")
    public List<ActorDTO> getAllRoles(@PathVariable("id") int id){
        Movie movie = service.get(id);

        List<Actor> actors = movie.getRoles().stream()
                .map(Role::getActor)
                .toList();

        List<ActorDTO> actorDTO = actors.stream()
                .map(ActorDTO::new)
                .toList();

        return actorDTO;
    }

    @GetMapping("/{id}/genres")
    public List<GenreDTO> getAllMovieGenres(@PathVariable("id") int id){
        Movie movie = service.get(id);

        List<GenreDTO> genreDTO = movie.getGenres().stream().map(GenreDTO::new).toList();

        return genreDTO;
    }

    @PostMapping("")
    public ResponseEntity<MovieDTO> addNewMovie(@RequestBody @Valid Movie movie){
        Movie createdMovie = service.save(movie);
        return new ResponseEntity<>(new MovieDTO(createdMovie), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/genres")
    public ResponseEntity<MovieDTO> addGenre(@PathVariable("id") int id, @RequestBody @Valid Genre genre){
        Movie updatedMovie = service.addGenre(id,genre);
        return new ResponseEntity<>(new MovieDTO(updatedMovie), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody @Valid Movie movie){
        Movie updatedMovie = service.save(movie);
        return new ResponseEntity<>(new MovieDTO(updatedMovie), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id")int id){
        Movie movie = service.get(id);

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}/genres/{id_genre}")
    public ResponseEntity<Void> removeGenre(@PathVariable("id") int id, @PathVariable("id_genre") int genreId){
        Movie movie = service.get(id);

        Genre genre = movie.getGenres().stream()
                .filter(g -> g.getId()==genreId)
                .findFirst()
                .orElse(null);

        service.removeGenre(id,genreId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
