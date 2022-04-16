package com.sem.movieap.controller.request;

import com.sem.movieap.MovieGenre;
import com.sem.movieap.service.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MovieRequest {

    @NotNull
    private Long watch_list_id;

    @NotBlank
    private String name;

    //@NotEmpty
    private MovieGenre genre;

    @NotNull
    private String releaseYear;

    @NotNull
    private String director;

    public Movie convertToMovie() {
        return Movie.builder()
                .watch_list_id(watch_list_id)
                .name(name)
                .genre(genre)
                .releaseYear(releaseYear)
                .director(director)
                .build();
    }
}
