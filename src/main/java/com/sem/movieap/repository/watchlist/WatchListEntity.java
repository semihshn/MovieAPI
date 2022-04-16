package com.sem.movieap.repository.watchlist;

import com.sem.movieap.repository.member.MemberEntity;
import com.sem.movieap.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "watchlist")
@Table(name = "watchlist")
public class WatchListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity member;

    @OneToMany(mappedBy = "watchList", fetch = FetchType.EAGER)
    private List<MovieEntity> movie;
}
