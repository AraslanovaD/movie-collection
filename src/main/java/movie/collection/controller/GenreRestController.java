package movie.collection.controller;

import jakarta.validation.Valid;
import movie.collection.dto.GenreDTO;
import movie.collection.dto.MovieDTO;
import movie.collection.entity.Genre;
import movie.collection.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreRestController {
    @Autowired
    private GenreService service;

    @GetMapping("")
    public List<GenreDTO> getAllGenres(){
        List<Genre> genre = service.getAll();

        List<GenreDTO> genreDTO = genre
                .stream()
                .map(GenreDTO::new)
                .toList();

        return genreDTO;
    }

    @GetMapping("/{id}")
    public GenreDTO getGenreById(@PathVariable("id") int id){
        Genre genre = service.get(id);
        return new GenreDTO(genre);
    }

    @GetMapping("/{id}/movies")
    public List<MovieDTO> getGenreMovies(@PathVariable("id") int id){
        Genre genre = service.get(id);

        List<MovieDTO> movieDTO = genre.getMovies().stream().map(MovieDTO::new).toList();

        return movieDTO;
    }

    @PostMapping("")
    public ResponseEntity<GenreDTO> addNewGenre(@RequestBody @Valid Genre genre){
        Genre createdGenre = service.save(genre);
        return new ResponseEntity<>(new GenreDTO(createdGenre), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<GenreDTO> updateGenre(@RequestBody @Valid Genre genre){
        Genre updatedGenre = service.save(genre);
        return new ResponseEntity<>(new GenreDTO(updatedGenre), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable("id")int id){
        service.get(id);

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
