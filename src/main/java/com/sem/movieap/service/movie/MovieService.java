package com.sem.movieap.service.movie;

public interface MovieService {

    Long create(Movie movie);

    Movie retrieve(Long id);
}
