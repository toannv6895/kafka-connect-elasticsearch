package com.toannguyen.movie_search.service;

import com.toannguyen.movie_search.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> searchMovies();

    List<Movie> searchMovies(String title);
}
