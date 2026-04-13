package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponse {
    private final Long id;
    private final String title;
    private final String contents;
    private final String name;
    private final LocalDateTime createdAt; // 추가
    private final LocalDateTime updatedAt; // 추가

    public GetScheduleResponse(
            Long id, String title, String contents, String name,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
