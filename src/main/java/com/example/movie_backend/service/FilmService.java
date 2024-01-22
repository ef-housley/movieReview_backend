package com.example.movie_backend.service;

import com.example.movie_backend.misc.FilmType;
import com.example.movie_backend.model.Film;
import com.example.movie_backend.repository.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepo filmRepo;

    public Optional<Film> getFilmById(int filmId){
        return filmRepo.findByFilmId(filmId);
    }

    public List<Film> getAllFilms(){
        return filmRepo.findAll();
    }

    public List<Film> getFilmsByType(FilmType filmType){
        return filmRepo.findByFilmTypeOrderByYearAndTitleAsc(filmType);
    }

    public Optional<Object> getStudioAndProducerByJoin(String filmTitle, int filmYear){
        return filmRepo.findStudioAndProducerByJoining(filmTitle, filmYear);
    }

    public List<Film> getFilmsByDuration(int filmDuration){
        return filmRepo.getFilmsByDurationGreater(filmDuration);
    }

}
