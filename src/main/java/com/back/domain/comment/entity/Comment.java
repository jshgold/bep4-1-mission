package com.back.domain.comment.entity;

import com.back.domain.member.entity.Member;
import com.back.domain.post.entity.Post;
import com.back.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseEntity {
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    public static Comment write(String content, Post post, Member author) {
        Comment comment = new Comment();
        comment.content = content;
        comment.post = post;
        comment.author = author;
        return comment;
    }
}
