package com.sem.movieap.repository.actor;

import com.sem.movieap.repository.member.MemberEntity;

public interface ActorDao {

    Long save(ActorEntity entity);

    ActorEntity retrieve(Long id);
}
