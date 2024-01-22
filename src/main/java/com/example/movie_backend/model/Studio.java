package com.example.movie_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "studios")
public class Studio {
    @Id
    private String studioName;

    private String studioAddress;

    @ManyToOne
    @JoinColumn(name = "president", referencedColumnName = "personId")
    private Person president;
}
