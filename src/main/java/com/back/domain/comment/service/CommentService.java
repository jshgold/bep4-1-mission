package com.back.domain.comment.service;

import com.back.domain.comment.entity.Comment;
import com.back.domain.comment.repository.CommentRepository;
import com.back.domain.member.entity.Member;
import com.back.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment write(String content, Post post, Member member) {
        Comment comment = Comment.write(content, post, member);
        Comment result = commentRepository.save(comment);
        return result;
    }

    public Long count() {
        Long cnt = commentRepository.count();
        return cnt;
    }

}
