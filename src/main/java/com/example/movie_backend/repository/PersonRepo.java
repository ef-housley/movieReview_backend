package com.example.movie_backend.repository;

import com.example.movie_backend.misc.Currency;
import com.example.movie_backend.misc.FilmType;
import com.example.movie_backend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface PersonRepo extends JpaRepository<Person, Integer> {

    List<Person>findAll();

    @Query("SELECT p FROM Person p WHERE p.incomeNet > :income AND p.currency = :currency")
    Optional<List<Person>> findPersonsByIncomeNetAndCurrency(float income, Currency currency);

    @Query("SELECT p FROM Person p WHERE p.gender = 1 ORDER BY p.incomeNet ASC LIMIT 1")
    Optional<Person>findFirstFemalePersonWithLowestIncome();

    @Query("SELECT p.personId, COUNT(f.filmTitle) AS nr_films " +
            "FROM Person p " +
            "LEFT JOIN Film f ON p.personId = f.producer.personId AND f.filmType = :filmType " +
            "WHERE p.personId = :personId " +
            "GROUP BY p.personId")
    Object findNumberOfSFFilmsByPersonId(int personId, FilmType filmType);


    @Query("SELECT MIN(p.incomeNet) AS CastigMinim, MAX(p.incomeNet) AS CastigMaxim " +
            "FROM Studio s JOIN Person p ON s.president.personId = p.personId")
    Map<String, Float> findMinMaxEarningsForStudioPresidents();
}
