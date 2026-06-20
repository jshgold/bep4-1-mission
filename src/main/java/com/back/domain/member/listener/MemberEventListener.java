package com.back.domain.member.listener;

import com.back.domain.member.dto.EventDto.*;
import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
public class MemberEventListener {
    private final MemberService memberService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    public void addPoint(PointEvent pointEvent) {
        Member member = memberService.findById(pointEvent.id());
        member.addPoint(pointEvent.point());
    }
}
