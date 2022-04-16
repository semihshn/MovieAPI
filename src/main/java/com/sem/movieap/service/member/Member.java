package com.sem.movieap.service.member;

import com.sem.movieap.repository.member.MemberEntity;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Member{

    private Long id;
    private String firstName;
    private String lastName;

    MemberEntity convertToMemberEntity() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setFirstName(getFirstName());
        memberEntity.setLastName(getLastName());
        return memberEntity;
    }

    public static Member convertFrom(MemberEntity entity) {
        return Member.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }
}
