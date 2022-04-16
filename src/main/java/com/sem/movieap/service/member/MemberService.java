package com.sem.movieap.service.member;

public interface MemberService {

    Long create(Member member);

    Member retrieve(Long id);
}
