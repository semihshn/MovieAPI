package com.sem.movieap.controller;

import com.sem.movieap.controller.request.MovieRequest;
import com.sem.movieap.controller.response.MovieCreateResponse;
import com.sem.movieap.controller.response.MovieResponse;
import com.sem.movieap.service.movie.Movie;
import com.sem.movieap.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieCreateResponse create(@RequestBody @Valid MovieRequest request) {
        Movie movie = request.convertToMovie();
        Long id = movieService.create(movie);
        return MovieCreateResponse.convertToMovieCreateResponse(id);
    }

    @GetMapping("/movies/{id}")
    public MovieResponse retrieve(@PathVariable Long id) {
        Movie movie = movieService.retrieve(id);
        return MovieResponse.convertFromMovie(movie);
    }
}
