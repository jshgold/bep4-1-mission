package com.back.domain.post.service;

import com.back.domain.member.dto.EventDto;
import com.back.domain.member.entity.Member;
import com.back.domain.post.dto.PostResponseDto;
import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto write(String title, String content, Member author) {
        Post post = Post.write(title, content, author);
        Post result = postRepository.save(post);
        return PostResponseDto.from(result);
    }


    public Long count() {
        Long cnt = postRepository.count();
        return cnt;
    }

    public Post findByReferenceId(Long referenceId) {
        Post post = postRepository.getReferenceById(referenceId);
        return post;
    }


}
