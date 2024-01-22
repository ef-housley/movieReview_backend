package com.example.movie_backend.repository;

import com.example.movie_backend.model.Distribution;
import com.example.movie_backend.model.DistributionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributionRepo extends JpaRepository<Distribution, DistributionId> {
    @Query("SELECT DISTINCT d1.actor.personId, d2.actor.personId " +
            "FROM Distribution d1 " +
            "JOIN Distribution d2 ON d1.film.filmTitle = d2.film.filmTitle AND d1.film.filmYear = d2.film.filmYear " +
            "WHERE d1.actor.personId <> d2.actor.personId " +
            "AND EXISTS (SELECT 1 FROM Person p1 WHERE p1.personId = d1.actor.personId AND p1.gender = 0) " +
            "AND EXISTS (SELECT 1 FROM Person p2 WHERE p2.personId = d2.actor.personId AND p2.gender = 1)")
    List<Object> findDistinctActorPairs();

}
