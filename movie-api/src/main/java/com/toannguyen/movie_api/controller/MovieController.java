package com.toannguyen.movie_api.controller;

import com.toannguyen.movie_api.mapper.MovieMapper;
import com.toannguyen.movie_api.model.Movie;
import com.toannguyen.movie_api.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Movie createMovie(@Valid @RequestBody CreateMovieRequest createMovieRequest) {
        return movieService.saveMovie(movieMapper.toMovie(createMovieRequest));
    }

    @PatchMapping("/{imdbId}")
    public Movie updateMovie(@PathVariable String imdbId, @RequestBody UpdateMovieRequest updateMovieRequest) {
        Movie movie = movieService.validateAndGetMovies(imdbId);
        movieMapper.updateMovieFromUpdateMovieRequest(movie, updateMovieRequest);
        return movieService.saveMovie(movie);
    }

    @DeleteMapping("/{imdbId}")
    public void deleteMovie(@PathVariable String imdbId) {
        Movie movie = movieService.validateAndGetMovies(imdbId);
        movieService.deleteMovie(movie);
    }
}