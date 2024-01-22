package com.example.movie_backend.repository;

import com.example.movie_backend.misc.FilmType;
import com.example.movie_backend.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface FilmRepo extends JpaRepository<Film, Integer> {
    Optional<Film> findByFilmId(int idFilm);
    List<Film> findAll();

    @Query("SELECT f FROM Film f WHERE f.filmType = :filmType ORDER BY f.filmYear, f.filmTitle ASC")
    List<Film> findByFilmTypeOrderByYearAndTitleAsc(FilmType filmType);

    @Query("SELECT s, p, f.producer.personId " + "FROM Studio s " + "JOIN Film f ON s.studioName = f.studio " +
            "JOIN Person p ON f.producer.personId = p.personId " +
            "WHERE f.filmTitle = :filmTitle AND f.filmYear = :filmYear")
    Optional<Object> findStudioAndProducerByJoining(String filmTitle, int filmYear);

    @Query("SELECT f FROM Film f WHERE f.filmDuration>:filmDuration")
    List<Film>getFilmsByDurationGreater(int filmDuration);

}
