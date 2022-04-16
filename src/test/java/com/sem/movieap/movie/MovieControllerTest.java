package com.sem.movieap.movie;

import com.sem.movieap.BaseIntegrationTest;
import com.sem.movieap.MovieGenre;
import com.sem.movieap.controller.request.MovieRequest;
import com.sem.movieap.controller.response.MovieCreateResponse;
import com.sem.movieap.repository.movie.MovieEntity;
import com.sem.movieap.repository.movie.MovieJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovieControllerTest extends BaseIntegrationTest {

    @Autowired
    MovieJpaRepository underTest;

    @Test
    @Sql(scripts = "/member-create.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/watch-list-create.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void it_should_create_movie() {

        // given
        MovieRequest request = new MovieRequest();
        request.setName("The Platform");
        request.setGenre(MovieGenre.ADULT);
        request.setReleaseYear("2019");
        request.setDirector("Galder Gaztelu-Urrutia");
        request.setWatch_list_id(1001L);

        // when
        ResponseEntity<MovieCreateResponse> response = testRestTemplate.postForEntity("/movies", request, MovieCreateResponse.class);

        // then
        Optional<MovieEntity> movie = underTest.findById(response.getBody().getId());
        assertThat(movie).isPresent();
        assertThat(movie.get().getName()).isEqualTo("The Platform");
    }
}
