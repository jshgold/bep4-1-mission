package com.back.domain.comment.dto;

import com.back.domain.comment.entity.Comment;

public record CommentResponseDto(
        String content,
        Long postId,
        Long authorId
) {
    public static CommentResponseDto from(Comment comment) {
        return new CommentResponseDto(
                comment.getContent(),
                comment.getPost().getId(),
                comment.getAuthor().getId()
        );
    }
}
