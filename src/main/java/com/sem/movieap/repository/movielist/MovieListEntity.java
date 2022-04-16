package com.sem.movieap.repository.movielist;

import com.sem.movieap.repository.watchlist.WatchListEntity;
import com.sem.movieap.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "movielist")
@Table(name = "movielist")
public class MovieListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private WatchListEntity watchList;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;
}
