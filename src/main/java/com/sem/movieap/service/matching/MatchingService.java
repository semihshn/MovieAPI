package com.sem.movieap.service.matching;

import com.sem.movieap.service.movielist.MovieList;

public interface MatchingService {
    Long create(Matching matching);

    Matching retrieve(Long id);
}
