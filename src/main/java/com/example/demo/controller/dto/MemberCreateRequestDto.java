package com.example.demo.controller.dto;

import com.example.demo.repository.entity.Member;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberCreateRequestDto {
    String name;
    Integer age;
    String job;
    String email;

    public Member toEntity() {
        return new Member(name , age , job , email);
    }

}
