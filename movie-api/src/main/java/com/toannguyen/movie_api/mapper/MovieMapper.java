package com.toannguyen.movie_api.mapper;

import com.toannguyen.movie_api.controller.CreateMovieRequest;
import com.toannguyen.movie_api.controller.UpdateMovieRequest;
import com.toannguyen.movie_api.model.Movie;

public interface MovieMapper {

    Movie toMovie(CreateMovieRequest createMovieRequest);

    void updateMovieFromUpdateMovieRequest(Movie movie, UpdateMovieRequest updateMovieRequest);
}
