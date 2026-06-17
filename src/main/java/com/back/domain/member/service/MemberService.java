package com.back.domain.member.service;

import com.back.domain.member.entity.Member;
import com.back.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;


    public void create() {

    }

    public void initCreate(String userName, String nickname) {
        Member member = Member.initCreate(userName, nickname);
    }

    public Long count() {
        Long cnt = memberRepository.count();
        return cnt;
    }


}
