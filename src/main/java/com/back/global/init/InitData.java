package com.back.global.init;

import com.back.domain.comment.service.CommentFacade;
import com.back.domain.comment.service.CommentService;
import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostFacade;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class InitData {

    @Autowired
    @Lazy
    private InitData self;
    private final MemberService memberService;
    private final PostFacade postFacade;
    private final PostService postService;
    private final CommentFacade commentFacade;
    private final CommentService commentService;

    @Bean
    ApplicationRunner initDataApplicationRunner() {
        return args -> {
            self.work1();
            self.work2();
            self.work3();
        };
    }

    @Transactional
    public void work1() {
        if(memberService.count() > 0) return;
        memberService.initCreate("system","시스템");
        memberService.initCreate("holding","홀딩");
        memberService.initCreate("admin","관리자");
        memberService.initCreate("user1","사용자1");
        memberService.initCreate("user2","사용자2");
        memberService.initCreate("user3","사용자3");
    }

    @Transactional
    public void work2() {
        if(postService.count() > 0) return;
        Member author1 = memberService.findById(4L);
        Member author2 = memberService.findById(5L);
        Member author3 = memberService.findById(6L);
        postFacade.writePostAndAddPoint("user1의 회고록 1번", "첫번째 프로젝트", author1);
        postFacade.writePostAndAddPoint("user1의 회고록 2번", "두번째 프로젝트", author1);
        postFacade.writePostAndAddPoint("user1의 회고록 3번", "세번째 프로젝트", author1);
        postFacade.writePostAndAddPoint("user2의 회고록 1번", "첫번째 프로젝트", author2);
        postFacade.writePostAndAddPoint("user2의 회고록 2번", "두번째 프로젝트", author2);
        postFacade.writePostAndAddPoint("user3의 회고록 1번", "세번째 프로젝트", author3);
    }


    @Transactional
    public void work3() {
        if(commentService.count() > 0) return;
        Member author1 = memberService.findById(4L);
        Member author2 = memberService.findById(5L);
        Member author3 = memberService.findById(6L);
        Post post1 = postService.findByReferenceId(1L);
        Post post2 = postService.findByReferenceId(2L);
        Post post3 = postService.findByReferenceId(3L);
        Post post4 = postService.findByReferenceId(4L);
        commentFacade.writeCommentAndAddPoint("댓글1", post1, author1);
        commentFacade.writeCommentAndAddPoint("댓글2", post1, author2);
        commentFacade.writeCommentAndAddPoint("댓글3", post1, author3);
        commentFacade.writeCommentAndAddPoint("댓글4", post2, author2);
        commentFacade.writeCommentAndAddPoint("댓글5", post2, author2);
        commentFacade.writeCommentAndAddPoint("댓글6", post3, author3);
        commentFacade.writeCommentAndAddPoint("댓글7", post3, author1);
        commentFacade.writeCommentAndAddPoint("댓글8", post4, author1);
    }
}
