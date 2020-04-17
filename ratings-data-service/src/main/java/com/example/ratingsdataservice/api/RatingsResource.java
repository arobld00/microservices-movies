package com.example.ratingsdataservice.api;

import com.example.ratingsdataservice.model.Rating;
import com.example.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RatingsResource.RATINGS_DATA)
public class RatingsResource {

    public static final String RATINGS_DATA = "/ratingsdata";

    public static final String MOVIES_ID = "/movies/{movieId}";
    public static final String USERS_ID = "/users/{userId}";

    @RequestMapping(RatingsResource.MOVIES_ID)
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping(RatingsResource.USERS_ID)
    public UserRating getRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }

}
