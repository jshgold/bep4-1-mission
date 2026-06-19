package com.back.domain.member.dto;

import com.back.domain.member.entity.Member;

public class EventDto {

    public record PointEvent(Long id, Integer point) {

    }
}
