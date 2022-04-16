package com.sem.movieap.repository.matching;

import com.sem.movieap.repository.actor.ActorEntity;
import com.sem.movieap.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "matching")
@Table(name = "matching")
public class MatchingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MovieEntity movie;

    @ManyToOne
    private ActorEntity actor;
}
