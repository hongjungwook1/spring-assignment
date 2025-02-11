package com.example.demo.repository.entity;

import com.example.demo.controller.dto.JobType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {
    Integer id;
    String name;
    Integer age;
    JobType job;
    String email;
    LocalDateTime createdAt;

    public Member(String name, Integer age, JobType job, String email, LocalDateTime createdAt) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.email = email;
        this.createdAt = createdAt;
    }
}
