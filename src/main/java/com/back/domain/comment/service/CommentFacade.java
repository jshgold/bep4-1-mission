package com.back.domain.comment.service;

import com.back.domain.comment.dto.CommentResponseDto;
import com.back.domain.comment.dto.CommentWritedEventDto;
import com.back.domain.member.entity.Member;
import com.back.domain.post.dto.PostResponseDto;
import com.back.domain.post.dto.PostWritedEventDto;
import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentFacade {
    private final CommentService commentService;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void writePostAndAddPoint(String content, Post post, Member author) {
        CommentResponseDto responseDto = commentService.write(content, post, author);
        eventPublisher.publishEvent(new CommentWritedEventDto(responseDto));
    }
}
