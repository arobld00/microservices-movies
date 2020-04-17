package com.example.movieinfoservice.persistence;

import com.example.movieinfoservice.model.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class DbInit implements CommandLineRunner {

    private MovieRepository movieRepository;

    public DbInit(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.movieRepository.deleteAll();

        Movie movie0 = new Movie("1", "El Origen del Planeta de los Simios", "Precuela del ya mítico largometraje.");
        Movie movie1 = new Movie("2", "Nacidos en China 2016", "Documental de la filial de Walt Disney Disneynature.");
        Movie movie2 = new Movie("3", "Código fuente", "2011");

        Collection<Movie> movies = Arrays.asList(movie0, movie1, movie2);

        this.movieRepository.insert(movies);
    }

}

