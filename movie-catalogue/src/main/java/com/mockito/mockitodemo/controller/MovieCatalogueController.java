package com.mockito.mockitodemo.controller;

import com.mockito.mockitodemo.models.CatalogueItem;
import com.mockito.mockitodemo.models.Movie;
import com.mockito.mockitodemo.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueController {
  @Autowired() private RestTemplate restTemplate;

  @Autowired WebClient.Builder webClientBuilder;

  @GetMapping("/{userid}")
  public ResponseEntity<List<CatalogueItem>> getCatalogue(@PathVariable("userid") String userId) {

    UserRating userRating =
        restTemplate.getForObject("http://localhost:8083/rating/users/" + userId, UserRating.class);
    List<CatalogueItem> catalogueItems =
        userRating.getUserRatings().stream()
            .map(
                rating -> {
                  Movie movie =
                      restTemplate.getForObject(
                          "http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
                  //                  Movie movie =
                  //                      webClientBuilder
                  //                          .build()
                  //                          .get()
                  //                          .uri("http://localhost:8081/movies/" +
                  // rating.getMovieId())
                  //                          .retrieve()
                  //                          .bodyToMono(Movie.class)
                  //                          .block();

                  return new CatalogueItem(movie.getName(), "some movie", rating.getRating());
                })
            .collect(Collectors.toList());
    return new ResponseEntity<List<CatalogueItem>>(catalogueItems, HttpStatus.OK);
  }
}
