package com.back.domain.post.service;

import com.back.domain.member.dto.EventDto;
import com.back.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostFacade {
    private final PostService postService;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void writePostAndAddPoint(String title, String content, Member author) {
        postService.write(title, content, author);
        eventPublisher.publishEvent(new EventDto.PointEvent(author.getId(), 3));
    }
}
