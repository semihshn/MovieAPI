package com.sem.movieap.service.movielist;

import com.sem.movieap.repository.movie.MovieEntity;
import com.sem.movieap.repository.watchlist.WatchListEntity;

public interface MovieListService {
    Long create(MovieList movieList);

    MovieList retrieve(Long id);
}
