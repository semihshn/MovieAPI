package com.sem.movieap.repository.rate;


public interface RateDao {

    Long save(RateEntity entity);

    RateEntity retrieve(Long movieId);
}
