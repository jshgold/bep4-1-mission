package com.back.domain.member.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nickName;

    public static Member initCreate(String userName,String nickName) {
        Member member = create(userName, nickName, "1234");
        return member;
    }

    public static Member create(String userName,String nickName, String password) {
        Member member = new Member();
        member.userName = userName;
        member.nickName = nickName;
        member.password = password;
        return member;
    }
}
