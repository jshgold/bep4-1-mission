package com.back.global.init;

import com.back.domain.member.service.MemberService;
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

    @Bean
    ApplicationRunner initDataApplicationRunner() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        if(memberService.count() >= 0) return;
        memberService.initCreate("system","시스템");
        memberService.initCreate("holding","홀딩");
        memberService.initCreate("admin","관리자");
        memberService.initCreate("user1","사용자1");
        memberService.initCreate("user2","사용자2");
        memberService.initCreate("user3","사용자3");
    }
}
