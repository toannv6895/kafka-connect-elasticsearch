package com.toannguyen.movie_api.service.Impl;

import com.toannguyen.movie_api.model.Movie;
import com.toannguyen.movie_api.repository.MovieRepository;
import com.toannguyen.movie_api.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie validateAndGetMovies(String imdbId) {
        return movieRepository.findById(imdbId)
                .orElseThrow(() -> new RuntimeException("Movie with id '%s' not found".formatted(imdbId)));
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}
