package com.example.moviecatalogservice.api;

import com.example.moviecatalogservice.business_services.MovieService;
import com.example.moviecatalogservice.business_services.UserRatingService;
import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(MovieCatalogResource.CATALOG)
public class MovieCatalogResource {

    public static final String CATALOG = "/catalog";

    public static final String USER_ID = "/{userId}";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserRatingService userRatingService;

    @RequestMapping(MovieCatalogResource.USER_ID)
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = userRatingService.getUserRating(userId);
        return userRating.getRatings().stream()
                .map(rating -> {
                    return movieService.getCatalogItem(rating);
                })
                .collect(Collectors.toList());
    }

    /*
    public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
        return Arrays.asList(new CatalogItem("no movie", "", 0));
    }
    */

}
