package com.example.movie_backend.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "distributions")
@IdClass(DistributionId.class)
public class Distribution {

    @Id
    @ManyToOne
    @JoinColumn(name = "actorId")
    private Person actor;

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "filmTitle", referencedColumnName = "filmTitle"),
            @JoinColumn(name = "filmYear", referencedColumnName = "filmYear")
    })
    private Film film;

}

//don't know if this class is needed yet