package com.sem.movieap.member;

import com.sem.movieap.service.member.Member;
import com.sem.movieap.service.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberServiceImpl underTest;

    @Test
    void it_should_add_new_member_successfully() {
        // given
        Member member = Member.builder()
                .firstName("test first name")
                .lastName("test last name")
                .build();
        // when
        final Long memberId = underTest.create(member);
        // then
        final Member result = underTest.retrieve(memberId);
        assertThat(result.getFirstName()).isEqualTo(member.getFirstName());
    }

    @Test
    void it_should_throw_exception_while_adding_new_member_because_of_null_first_name() {
        // given
        Member member = Member.builder()
                .lastName("test last name")
                .build();

        Exception exception = null;
        // when
        try {
            underTest.create(member);
        } catch (Exception e) {
            exception = e;
        }
        // then
        assertThat(exception).isNotNull();
    }
}
