package com.sem.movieap.service.matching;

import com.sem.movieap.repository.actor.ActorEntity;
import com.sem.movieap.repository.matching.MatchingEntity;
import com.sem.movieap.repository.movie.MovieEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class Matching {
    private Long id;
    private Long movieId;
    private Long actorId;

    MatchingEntity convertToMatchingEntity(MovieEntity movieEntity, ActorEntity actorEntity) {
        MatchingEntity matchingEntity = new MatchingEntity();
        matchingEntity.setMovie(movieEntity);
        matchingEntity.setActor(actorEntity);
        return matchingEntity;
    }

    public static Matching convertFrom(MatchingEntity entity) {
        return Matching.builder()
                .movieId(entity.getMovie().getId())
                .actorId(entity.getActor().getId())
                .build();
    }
}
