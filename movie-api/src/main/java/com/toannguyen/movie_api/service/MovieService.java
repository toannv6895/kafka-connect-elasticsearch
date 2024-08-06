package com.toannguyen.movie_api.service;

import com.toannguyen.movie_api.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getMovies();

    Movie validateAndGetMovies(String imdbId);

    Movie saveMovie(Movie movie);

    void deleteMovie(Movie movie);
}
