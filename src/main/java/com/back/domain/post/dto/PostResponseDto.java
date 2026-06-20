package com.back.domain.post.dto;

public record PostResponseDto(
        String title,
        String content,
        Long authorId
) {
}
