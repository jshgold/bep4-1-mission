package com.back.domain.post.dto;

import com.back.domain.post.entity.Post;

public record PostResponseDto(
        String title,
        String content,
        Long authorId
) {

    public static PostResponseDto from(Post post) {
        return new PostResponseDto(
                post.getTitle(),
                post.getContent(),
                post.getAuthor().getId()
        );
    }
}
