package com.back.domain.member.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseEntity {
    String userName;
    String password;
    String nickName;
}
