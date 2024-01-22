package com.example.movie_backend.contoller;

import com.example.movie_backend.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dist")
@CrossOrigin(origins = "http://localhost:3000")
public class DistributionController {
    @Autowired
    DistributionService distributionService;

    @GetMapping("/getActorPairs")
    public List<Object> getActorPairs(){
        return distributionService.getActorPairs();
    }

}
