package com.back.global.init;

import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class InitData {
    @Autowired
    @Lazy
    private InitData self;
    private final MemberService memberService;
    private final PostService postService;

    @Bean
    ApplicationRunner initDataApplicationRunner() {
        return args -> {
            self.work1();
            self.work2();
        };
    }

    @Transactional
    public void work1() {
        if(memberService.count() > 0) return;
        memberService.initCreate("system","시스템");
        memberService.initCreate("holding","홀딩");
        memberService.initCreate("admin","관리자");
        memberService.initCreate("user1","사용자1");
        memberService.initCreate("user2","사용자2");
        memberService.initCreate("user3","사용자3");
    }

    @Transactional
    public void work2() {
        if(postService.count() > 0) return;
        Member author1 = memberService.findByReferenceId(4L);
        Member author2 = memberService.findByReferenceId(5L);
        Member author3 = memberService.findByReferenceId(6L);
        postService.create("user1의 회고록 1번", "첫번째 프로젝트", author1);
        postService.create("user1의 회고록 2번", "두번째 프로젝트", author1);
        postService.create("user1의 회고록 3번", "세번째 프로젝트", author1);
        postService.create("user2의 회고록 1번", "첫번째 프로젝트", author2);
        postService.create("user2의 회고록 2번", "두번째 프로젝트", author2);
        postService.create("user3의 회고록 1번", "세번째 프로젝트", author3);
    }
}
