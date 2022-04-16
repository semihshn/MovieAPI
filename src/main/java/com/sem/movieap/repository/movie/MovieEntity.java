package com.sem.movieap.repository.movie;

import com.sem.movieap.MovieGenre;
import com.sem.movieap.repository.matching.MatchingEntity;
import com.sem.movieap.repository.movielist.MovieListEntity;
import com.sem.movieap.repository.rate.RateEntity;
import com.sem.movieap.repository.watchlist.WatchListEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "movie")
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    private String releaseYear;

    @Column(nullable = false)
    private String director;

    @OneToMany(mappedBy = "movie")
    private List<RateEntity> ratesEntities;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<MovieListEntity> movieListEntities;

    @OneToMany(mappedBy = "movie")
    private List<MatchingEntity> matchingEntities;

    @ManyToOne
    @JoinColumn(nullable = false)
    private WatchListEntity watchList;
}
