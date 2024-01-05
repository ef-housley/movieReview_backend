package com.example.movie_backend.model;

import com.example.movie_backend.misc.FilmType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "films", uniqueConstraints = {@UniqueConstraint(columnNames = {"filmTitle", "filmYear"})})
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    private String filmTitle;
    private int filmYear;
    private int filmDuration;
    private FilmType filmType;
    private String studio;

    @ManyToOne
    @JoinColumn(name = "producerId", referencedColumnName = "personId")
    private Person producer;
}
