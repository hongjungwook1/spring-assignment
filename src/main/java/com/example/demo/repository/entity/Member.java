package com.example.demo.repository.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {
    Integer id;
    String name;
    Integer age;
    String job;
    String email;

    public Member (String name , Integer age , String job , String email) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.email = email;
    }
}
