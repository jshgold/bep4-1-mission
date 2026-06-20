package com.back.domain.comment.service;

import com.back.domain.comment.dto.CommentResponseDto;
import com.back.domain.comment.entity.Comment;
import com.back.domain.comment.repository.CommentRepository;
import com.back.domain.member.entity.Member;
import com.back.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponseDto write(String content, Post post, Member author) {
        Comment comment = Comment.write(content, post, author);
        Comment result = commentRepository.save(comment);
        return CommentResponseDto.from(result);
    }

    public Long count() {
        Long cnt = commentRepository.count();
        return cnt;
    }

}
