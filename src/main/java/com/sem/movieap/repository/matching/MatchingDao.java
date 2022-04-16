package com.sem.movieap.repository.matching;

import com.sem.movieap.repository.actor.ActorEntity;

public interface MatchingDao {
    Long save(MatchingEntity entity);

    MatchingEntity retrieve(Long id);
}
