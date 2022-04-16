package com.sem.movieap.member;

import com.sem.movieap.BaseIntegrationTest;
import com.sem.movieap.MovieGenre;
import com.sem.movieap.controller.request.MemberRequest;
import com.sem.movieap.controller.request.MovieRequest;
import com.sem.movieap.controller.response.MemberCreateResponse;
import com.sem.movieap.controller.response.MemberResponse;
import com.sem.movieap.controller.response.MovieCreateResponse;
import com.sem.movieap.repository.member.MemberEntity;
import com.sem.movieap.repository.member.MemberJpaRepository;
import com.sem.movieap.repository.movie.MovieEntity;
import com.sem.movieap.repository.movie.MovieJpaRepository;
import com.sem.movieap.service.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberControllerTest extends BaseIntegrationTest {

    @Autowired
    MemberJpaRepository underTest;

    @Autowired
    RedisTemplate<String, Member> memberRedisTemplate;

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void it_should_create_member() {

        // given
        MemberRequest request = new MemberRequest();
        request.setFirstName("test first name");
        request.setLastName("test last name");

        // when
        ResponseEntity<MemberCreateResponse> response = testRestTemplate.postForEntity("/members", request, MemberCreateResponse.class);

        // then
        Optional<MemberEntity> member = underTest.findById(response.getBody().getId());
        assertThat(member).isPresent();
        assertThat(member.get().getFirstName()).isEqualTo("test first name");
    }

    @Test
    @Sql(scripts = "/member-create.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void it_should_retrieve_member() {
        // given
        // via Sql Annotation

        // when
        ResponseEntity<MemberResponse> response = testRestTemplate.getForEntity("/members/1002", MemberResponse.class);

        // then
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody())
                .extracting("firstName", "lastName")
                .containsExactly("test first name 2", "test last name 2");

        //validate-cache
        Member member = memberRedisTemplate.opsForValue().get("semih:movie:" + 1002);
        assertThat(member).isNotNull();
        assertThat(member.getFirstName()).isEqualTo("test first name 2");
    }
}
