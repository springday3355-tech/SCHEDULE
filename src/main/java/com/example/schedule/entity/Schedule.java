package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String name;
    private String password;
    private Integer date;

    public Schedule(String title, String contents, String name, String password, Integer date){
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.password = password;
        this.date = date;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContents(String contents) {
        this.contents = contents;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateDate(Integer date) {
        this.date = date;
    }
}
