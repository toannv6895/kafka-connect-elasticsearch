package com.toannguyen.movie_api.repository;

import com.toannguyen.movie_api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}