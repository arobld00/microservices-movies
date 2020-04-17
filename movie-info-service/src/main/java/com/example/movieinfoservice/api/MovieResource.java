package com.example.movieinfoservice.api;

import com.example.movieinfoservice.model.Movie;
import com.example.movieinfoservice.model.MovieSummary;
import com.example.movieinfoservice.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(MovieResource.MOVIES)
public class MovieResource {

    public static final String MOVIES = "/movies";

    public static final String MOVIE_ID = "/{movieId}";

    /*@Value("${api.key}")
    private String apiKey;*/

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(MovieResource.MOVIE_ID)
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        //MovieSummary movieSummary = restTemplate.getForObject("http://localhost:8083/movies" + movieId + "?api_key=" + apiKey, MovieSummary.class);
        //return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
        return (Movie) this.movieRepository.findById(movieId).orElse(null);
    }

}

