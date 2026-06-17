package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;


    public void create() {
        String userName = "";
        String password = "";
        String nickname = "";
        Post member = Post.create(userName, nickname, password);
        Post result = postRepository.save(member);
    }

    public void initCreate(String userName, String nickname) {
        Post member = Post.initCreate(userName, nickname);
        Post result = postRepository.save(member);
    }

    public Long count() {
        Long cnt = postRepository.count();
        return cnt;
    }


}
