package com.example.demo.controller.dto;

import com.example.demo.repository.entity.Member;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberCreateRequestDto {
    String name;
    Integer age;
    JobType job;
    String email;
    LocalDateTime createdAt;

    public Member toEntity() {
        return new Member(name, age, job, email, createdAt);
    }

}
