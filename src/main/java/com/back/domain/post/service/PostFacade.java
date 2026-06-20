package com.back.domain.post.service;

import com.back.domain.member.entity.Member;
import com.back.domain.post.dto.PostResponseDto;
import com.back.domain.post.dto.PostWritedEventDto;
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
        PostResponseDto responseDto = postService.write(title, content, author);
        eventPublisher.publishEvent(new PostWritedEventDto(responseDto));
    }
}
