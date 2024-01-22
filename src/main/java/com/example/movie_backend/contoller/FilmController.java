package com.example.movie_backend.contoller;


import com.example.movie_backend.misc.FilmType;
import com.example.movie_backend.model.Film;
import com.example.movie_backend.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/film")
@CrossOrigin(origins = "http://localhost:3000")
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping("/getFilm/{id}")
    public Optional<Film> getFilmInfo(@PathVariable(name= "id")int id){
        return filmService.getFilmById(id);
    }

    @GetMapping("getAllFilms")
    public List<Film> getAllProducts(){
        return filmService.getAllFilms();
    }

    @GetMapping("/getFilmsByType/{genre}")
    public List<Film>getFilmsByType(@PathVariable(name = "genre") FilmType filmType){
        return filmService.getFilmsByType(filmType);
    }

    @GetMapping("/getStudioAndProducerByJoin")
    public Optional<Object>getStudioAndProducerByJoin (
            @RequestParam(name = "filmTitle") String filmTitle,
            @RequestParam(name = "filmYear") int filmYear){
        return filmService.getStudioAndProducerByJoin(filmTitle, filmYear);
    }

    @GetMapping("/getFilmsByDuration/{duration}")
    public List<Film> getFilmsByDuration(@PathVariable(name = "duration") int duration){
        return filmService.getFilmsByDuration(duration);
    }
}
