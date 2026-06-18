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
        String userName = "";
        String password = "";
        String nickname = "";
        Member member = Member.create(userName, nickname, password);
        Member result = memberRepository.save(member);
    }

    public void initCreate(String userName, String nickname) {
        Member member = Member.initCreate(userName, nickname);
        Member result = memberRepository.save(member);
    }

    public Long count() {
        Long cnt = memberRepository.count();
        return cnt;
    }

    public Member findByReferenceId(Long id) {
        return memberRepository.getReferenceById(id);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(RuntimeException::new);
    }


}
