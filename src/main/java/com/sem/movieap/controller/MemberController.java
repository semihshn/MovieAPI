package com.sem.movieap.controller;

import com.sem.movieap.controller.request.MemberRequest;
import com.sem.movieap.controller.response.MemberCreateResponse;
import com.sem.movieap.controller.response.MemberResponse;
import com.sem.movieap.service.member.Member;
import com.sem.movieap.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberCreateResponse create(@RequestBody MemberRequest request) {
        Member member = request.convertToMember();
        Long id = memberService.create(member);
        return MemberCreateResponse.convertToMemberCreateResponse(id);
    }

    @GetMapping("/members/{id}")
    public MemberResponse retrieve(@PathVariable Long id) {
        Member member = memberService.retrieve(id);
        return MemberResponse.convertFromMember(member);
    }


}
