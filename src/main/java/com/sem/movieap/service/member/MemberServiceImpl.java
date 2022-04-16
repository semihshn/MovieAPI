package com.sem.movieap.service.member;

import com.sem.movieap.repository.member.MemberDao;
import com.sem.movieap.repository.member.MemberEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberDao memberDao;
    private final RedisTemplate<String, Member> memberRedisTemplate;

    @Override
    public Long create(Member member) {
        MemberEntity memberEntity = member.convertToMemberEntity();
        return memberDao.save(memberEntity);
    }

    @Override
    public Member retrieve(Long id) {
        Member member = memberRedisTemplate.opsForValue().get("semih:member:" + id);
        log.info("Member is retrieving: {}", id);

        if(member == null) {
            log.info("Member cache is updating: {}", id);
            MemberEntity entity = memberDao.retrieve(id);
            member = Member.convertFrom(entity);
            memberRedisTemplate.opsForValue().set("semih:movie:" + id, member, Duration.ofSeconds(30));
            return member;
        }

        return member;
    }
}
