package com.example.movie_backend.model;

import com.example.movie_backend.misc.Currency;
import com.example.movie_backend.misc.Gender;

import java.util.Date;

public class Person {
    private int personId;
    private String fullName;
    private String address;
    private String email;
    private Gender gender;
    private Date dateOfBirth;
    private float incomeNet;
    private Currency currency;

}
