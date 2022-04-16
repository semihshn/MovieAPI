package com.sem.movieap.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreateResponse {

    private Long id;

    public static MovieCreateResponse convertToMovieCreateResponse(Long id) {
        return MovieCreateResponse.builder()
                .id(id)
                .build();
    }
}
