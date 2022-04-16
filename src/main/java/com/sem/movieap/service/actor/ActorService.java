package com.sem.movieap.service.actor;

import com.sem.movieap.service.matching.Matching;

public interface ActorService {
    Long create(Actor actor);

    Actor retrieve(Long id);
}
