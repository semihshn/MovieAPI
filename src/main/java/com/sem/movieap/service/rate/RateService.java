package com.sem.movieap.service.rate;

public interface RateService {

    Long create(Rate rate);

    Rate retrieve(Long movieId);
}
