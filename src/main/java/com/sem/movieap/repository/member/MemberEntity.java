package com.sem.movieap.repository.member;

import com.sem.movieap.repository.rate.RateEntity;
import com.sem.movieap.repository.watchlist.WatchListEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "member")
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<WatchListEntity> watchListEntities;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<RateEntity> rateEntities;
}
