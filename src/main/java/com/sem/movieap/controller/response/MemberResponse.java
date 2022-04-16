package com.sem.movieap.controller.response;

import com.sem.movieap.service.member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponse {

    private String firstName;
    private String lastName;

    public static MemberResponse convertFromMember(Member member) {
        return MemberResponse.builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .build();
    }
}

//3 layered
//N Layered
