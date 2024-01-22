package com.example.movie_backend.model;

import com.example.movie_backend.misc.Currency;
import com.example.movie_backend.misc.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Exceptions")
public class Exception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exceptionId;

    private int personId;
    private String fullName;
    private String address;
    private Gender gender;
    private Date dateOfBirth;
    private float incomeNet;
    private Currency currency;
    private String exceptionMessage;
}
