package com.sem.movieap.service.movielist;

import com.sem.movieap.repository.movie.MovieEntity;
import com.sem.movieap.repository.movielist.MovieListEntity;
import com.sem.movieap.repository.watchlist.WatchListEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class MovieList {
    private Long watchListId;
    private Long movieId;

    MovieListEntity convertToMovieListEntity(WatchListEntity watchListEntity,MovieEntity movieEntity) {
        MovieListEntity movieListEntity = new MovieListEntity();
        movieListEntity.setMovie(movieEntity);
        movieListEntity.setWatchList(watchListEntity);
        return movieListEntity;
    }

    public static MovieList convertFrom(MovieListEntity entity) {
        return MovieList.builder()
                .movieId(entity.getMovie().getId())
                .watchListId(entity.getWatchList().getId())
                .build();
    }

}
