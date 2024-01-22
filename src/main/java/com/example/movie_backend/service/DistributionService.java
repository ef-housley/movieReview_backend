package com.example.movie_backend.service;


import com.example.movie_backend.repository.DistributionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionService {
    @Autowired
    DistributionRepo distributionRepo;

    public List<Object>getActorPairs(){
        return distributionRepo.findDistinctActorPairs();
    }

}
