package com.mockito.mockitodemo.controller;

import com.mockito.mockitodemo.models.Rating.Rating;
import com.mockito.mockitodemo.models.Rating.UserRating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/rating")
public class RatingController {
  @GetMapping("/{movieId}")
  public ResponseEntity<Rating> getRating(@PathVariable String movieId) {
    return new ResponseEntity<Rating>(new Rating(movieId, 5), HttpStatus.OK);
  }

  @GetMapping("/users/{userid}")
  public ResponseEntity<UserRating> getUserRatings(@PathVariable("userid") String userId) {
    List<Rating> ratings =
        Arrays.asList(new Rating("345435", 5), new Rating("3454223", 5), new Rating("345498", 5));
    var userRating = new UserRating();
    userRating.setUserRatings(ratings);
    return new ResponseEntity<UserRating>(userRating, HttpStatus.OK);
  }
}
