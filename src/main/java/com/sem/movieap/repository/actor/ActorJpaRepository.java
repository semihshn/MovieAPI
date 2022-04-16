package com.sem.movieap.repository.actor;

import com.sem.movieap.repository.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorJpaRepository extends JpaRepository<ActorEntity, Long> {
}
