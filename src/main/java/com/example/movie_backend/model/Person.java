package com.example.movie_backend.model;

import com.example.movie_backend.misc.Currency;
import com.example.movie_backend.misc.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    private String fullName;
    private String address;
    private String email;
    private Gender gender;
    private Date dateOfBirth;
    private float incomeNet;
    private Currency currency;
}
