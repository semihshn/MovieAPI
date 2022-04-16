package com.sem.movieap.repository.matching;

import com.sem.movieap.repository.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchingJpaRepository extends JpaRepository<MatchingEntity, Long> {
}
