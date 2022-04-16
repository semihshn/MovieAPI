package com.sem.movieap.repository.movie;

public interface MovieDao {

    Long save(MovieEntity entity);

    MovieEntity retrieve(Long id);

}
