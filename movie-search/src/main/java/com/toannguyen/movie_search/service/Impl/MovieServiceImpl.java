package com.toannguyen.movie_search.service.Impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.toannguyen.movie_search.model.Movie;
import com.toannguyen.movie_search.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final ElasticsearchClient client;

    @Value("${elasticsearch.indexes.movies}")
    private String moviesIndex;

    @Override
    public List<Movie> searchMovies() {
        return searchMovies(
                SearchRequest.of(
                        searchRequestBuilder -> searchRequestBuilder.index(moviesIndex)));
    }

    @Override
    public List<Movie> searchMovies(String title) {
        return searchMovies(
                SearchRequest.of(
                        searchRequestBuilder -> searchRequestBuilder
                                .index(moviesIndex)
                                .query(queryBuilder -> queryBuilder
                                        .term(termQueryBuilder -> termQueryBuilder
                                                .field("title").value(title)))));
    }

    private List<Movie> searchMovies(SearchRequest searchRequest) {
        try {
            SearchResponse<Movie> searchResponse = client.search(searchRequest, Movie.class);
            List<Hit<Movie>> hits = searchResponse.hits().hits();
            return hits.stream().map(Hit::source).toList();
        } catch (Exception e) {
            throw new RuntimeException(
                    "An exception occurred while searching movies. %s".formatted(e.getMessage()));
        }
    }
}
