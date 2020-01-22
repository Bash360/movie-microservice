package com.mockito.mockitodemo.controller;

import com.mockito.mockitodemo.models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
  @GetMapping("/{id}")
  public ResponseEntity<Movie> getMovieInfo(@PathVariable("id") String movieId) {

    return new ResponseEntity<Movie>(new Movie(movieId, "killshot"), HttpStatus.OK);
  }
}
