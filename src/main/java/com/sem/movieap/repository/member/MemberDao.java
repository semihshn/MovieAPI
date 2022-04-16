package com.sem.movieap.repository.member;

public interface MemberDao {

    Long save(MemberEntity entity);

    MemberEntity retrieve(Long id);
}
