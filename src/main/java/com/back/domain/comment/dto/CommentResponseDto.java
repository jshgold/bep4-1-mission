package com.back.domain.comment.dto;

public record CommentResponseDto(
        String content,
        Long postId,
        Long authorId
) {
}
