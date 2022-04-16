package com.sem.movieap.repository.rate;

import com.sem.movieap.repository.member.MemberEntity;
import com.sem.movieap.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "rate")
@Table(name = "rate")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private Integer point;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;
}
