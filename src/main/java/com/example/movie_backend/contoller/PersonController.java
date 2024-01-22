package com.example.movie_backend.contoller;

import com.example.movie_backend.misc.Currency;
import com.example.movie_backend.misc.FilmType;
import com.example.movie_backend.model.Person;
import com.example.movie_backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("getAllPeople")
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("/getPersonsByIncomeAndCurrency")
    public Optional<List<Person>> getPersonsByIncomeNetAndCurrency(
            @RequestParam(name = "income") float incomeNet,
            @RequestParam(name = "currency") Currency currency){
        return personService.getPersonsByIncomeNetAndCurrency(incomeNet, currency);
    }

    @GetMapping("/getFemaleWithTheLowestIncome")
    public Optional<Person>getFemaleWithTheLowestIncome(){
        return personService.getFemaleWithTheLowestIncome();
    }

    @GetMapping("/getPersonWithFilmType")
    public Object getPersonWithFilmType(
            @RequestParam(name = "personId") int personId,
            @RequestParam(name = "filmType") FilmType filmType){
        return personService.getPersonWithFilmType(personId, filmType);
    }

    @GetMapping("/minMaxIncomePerson")
    public Map<String, Float> findMinMaxIncomeForStudioPresidents() {
        return personService.findMinMaxIncomeForStudioPresidents();
    }
}