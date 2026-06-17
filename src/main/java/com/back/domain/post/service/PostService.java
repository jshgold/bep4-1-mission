package com.back.domain.post.service;

import com.back.domain.member.entity.Member;
import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;


    public void create(String title, String content, Member author) {
        Post post = Post.create(title, content, author);
        Post result = postRepository.save(post);
    }


    public Long count() {
        Long cnt = postRepository.count();
        return cnt;
    }


}
