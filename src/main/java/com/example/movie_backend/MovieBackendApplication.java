package com.example.movie_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MovieBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBackendApplication.class, args);
    }
}
