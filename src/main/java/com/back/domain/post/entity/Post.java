package com.back.domain.post.entity;

import com.back.domain.member.entity.Member;
import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    public static Post initCreate(String userName, String nickName) {
        Post member = create(userName, nickName, "1234");
        return member;
    }

    public static Post create(String userName, String nickName, String password) {
        Post member = new Post();
        member.userName = userName;
        member.nickName = nickName;
        member.password = password;
        return member;
    }
}
