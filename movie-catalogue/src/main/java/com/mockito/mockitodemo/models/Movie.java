package com.mockito.mockitodemo.models;

public class Movie {
  private String id;
  private String name;

  public Movie(String id, String name) {
    this.id = id;
    this.name = name;
  }

  private Movie() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
