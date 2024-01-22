package com.example.movie_backend.service;
import com.example.movie_backend.misc.Currency;
import com.example.movie_backend.misc.FilmType;
import com.example.movie_backend.model.Person;
import com.example.movie_backend.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;

    public List<Person>getAllPeople(){
        return personRepo.findAll();
    }

    public Optional<List<Person>> getPersonsByIncomeNetAndCurrency(float income, Currency currency){
        return personRepo.findPersonsByIncomeNetAndCurrency(income, currency);
    }

    public Optional<Person>getFemaleWithTheLowestIncome(){
        return personRepo.findFirstFemalePersonWithLowestIncome();
    }

    public Object getPersonWithFilmType(int personId, FilmType filmType){
        return personRepo.findNumberOfSFFilmsByPersonId(personId, filmType);
    }


    public Map<String, Float> findMinMaxIncomeForStudioPresidents(){
        return personRepo.findMinMaxEarningsForStudioPresidents();
    }


}
