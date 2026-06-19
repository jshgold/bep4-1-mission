package com.back.domain.member.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.event.TransactionalEventListener;

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

    private Integer point = 0;

    //쓸 이유가 없네.. 조회를 하려고해도 한번에 10,000개를 가져오니까 안되고, 삭제를 하려고해도 요즘은 SoftDelete니까 이유가없고,
    //insert는 뭐 굳이 바로 조회하는거 아니면 1차캐시하고 DB 상태 맞출 이유 없으니까 일시적으로 틀어져도 문제없으니
//    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Post> posts;

    public static Member initCreate(String userName, String nickName) {
        Member member = create(userName, nickName, "1234");
        return member;
    }

    public static Member create(String userName, String nickName, String password) {
        Member member = new Member();
        member.userName = userName;
        member.nickName = nickName;
        member.password = password;
        return member;
    }

    public void addPoint(int point) {
        this.point += point;
    }
}
