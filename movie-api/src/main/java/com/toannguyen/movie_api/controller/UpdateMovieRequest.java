package com.toannguyen.movie_api.controller;

public record UpdateMovieRequest(String title, Integer year, String actors, String poster) {
}
