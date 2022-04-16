package com.sem.movieap.controller.response;

import com.sem.movieap.service.rate.Rate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class RateResponse {

    private LocalDateTime createdDate;
    private Long memberId;
    private Long movieId;
    private Integer point;

    public static List<RateResponse> convertFromRate(List<Rate> rateList) {
        return rateList.stream()
                .map(RateResponse::convertFromRate)
                .toList();
    }

    public static RateResponse convertFromRate(Rate rate) {
        return RateResponse.builder()
                .createdDate(rate.getCreatedDate())
                .memberId(rate.getMemberId())
                .movieId(rate.getMovieId())
                .point(rate.getPoint())
                .build();
    }
}
