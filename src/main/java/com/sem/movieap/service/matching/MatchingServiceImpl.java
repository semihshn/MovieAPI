package com.sem.movieap.service.matching;

import com.sem.movieap.repository.actor.ActorDao;
import com.sem.movieap.repository.actor.ActorEntity;
import com.sem.movieap.repository.matching.MatchingDao;
import com.sem.movieap.repository.matching.MatchingEntity;
import com.sem.movieap.repository.movie.MovieDao;
import com.sem.movieap.repository.movie.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService{

    private final MatchingDao matchingDao;
    private final MovieDao movieDao;
    private final ActorDao actorDao;

    @Override
    public Long create(Matching matching) {
        MovieEntity movieEntity= movieDao.retrieve(matching.getMovieId());
        ActorEntity actorEntity=actorDao.retrieve(matching.getActorId());

        MatchingEntity matchingEntity=matching.convertToMatchingEntity(movieEntity,actorEntity);

        return matchingDao.save(matchingEntity);
    }

    @Override
    public Matching retrieve(Long id) {
        MatchingEntity matchingEntity=matchingDao.retrieve(id);
        return Matching.convertFrom(matchingEntity);
    }
}
