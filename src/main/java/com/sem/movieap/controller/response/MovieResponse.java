package com.sem.movieap.controller.response;

import com.sem.movieap.MovieGenre;
import com.sem.movieap.service.movie.Movie;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MovieResponse {

    private String name;
    private MovieGenre genre;
    private String releaseYear;
    private String director;
    private List<CastResponse> castList;

    public static MovieResponse convertFromMovie(Movie movie) {
        return MovieResponse.builder()
                .name(movie.getName())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirector())
                .build();
    }
}
