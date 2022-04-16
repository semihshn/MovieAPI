package com.sem.movieap.controller.response;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberCreateResponse {

    private Long id;

    public static MemberCreateResponse convertToMemberCreateResponse(Long id) {
        return MemberCreateResponse.builder()
                .id(id)
                .build();
    }
}
