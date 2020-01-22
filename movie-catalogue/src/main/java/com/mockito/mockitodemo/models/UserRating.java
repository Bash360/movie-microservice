package com.mockito.mockitodemo.models;

import java.util.List;

public class UserRating {
  private List<Rating> userRatings;

  private UserRating() {}

  public UserRating(List<Rating> userRatings) {
    this.userRatings = userRatings;
  }

  public List<Rating> getUserRatings() {
    return userRatings;
  }

  public void setUserRatings(List<Rating> userRatings) {
    this.userRatings = userRatings;
  }
}
