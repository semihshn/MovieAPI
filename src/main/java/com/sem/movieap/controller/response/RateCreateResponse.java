package com.sem.movieap.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateCreateResponse {
    private Long id;

    public static RateCreateResponse convertToRateCreateResponse(Long id) {
        return RateCreateResponse.builder()
                .id(id)
                .build();
    }
}
