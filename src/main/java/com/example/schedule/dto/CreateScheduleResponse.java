package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleResponse {

    private final long id;
    private final String title;
    private final String contents;
    private final String name;
    private final String password;
    private final Integer date;

    public CreateScheduleResponse(long id, String title, String contents, String name, String password, Integer date) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.password = password;
        this.date = date;
    }
}
