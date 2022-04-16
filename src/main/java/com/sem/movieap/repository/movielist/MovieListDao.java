package com.sem.movieap.repository.movielist;

public interface MovieListDao {
    Long save(MovieListEntity entity);

    MovieListEntity retrieve(Long id);

}
