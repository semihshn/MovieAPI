package com.sem.movieap.controller.request;

import com.sem.movieap.service.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public Member convertToMember() {
        return Member.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
