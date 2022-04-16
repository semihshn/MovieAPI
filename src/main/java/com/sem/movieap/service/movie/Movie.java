package com.sem.movieap.service.movie;

import com.sem.movieap.MovieGenre;
import com.sem.movieap.repository.movie.MovieEntity;
import com.sem.movieap.repository.watchlist.WatchListEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class Movie {

    private Long watch_list_id;
    private String name;
    private MovieGenre genre;
    private String releaseYear;
    private String director;

    MovieEntity convertToMovieEntity(WatchListEntity watchListEntity) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setWatchList(watchListEntity);
        movieEntity.setName(getName());
        movieEntity.setDirector(getDirector());
        movieEntity.setReleaseYear(getReleaseYear());
        movieEntity.setGenre(getGenre());
        return movieEntity;
    }

    public static Movie convertFrom(MovieEntity entity) {
        return Movie.builder()
                .name(entity.getName())
                .genre(entity.getGenre())
                .releaseYear(entity.getReleaseYear())
                .director(entity.getDirector())
                .build();
    }
}
