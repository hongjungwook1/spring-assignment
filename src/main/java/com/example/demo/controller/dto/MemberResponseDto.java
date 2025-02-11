package com.example.demo.controller.dto;

import com.example.demo.repository.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class MemberResponseDto {
    Integer id;
    String name;
    Integer age;
    String job;
    String email;

    public static MemberResponseDto of(Member member){
        return new MemberResponseDto(
                member.getId() ,
                member.getName(),
                member.getAge() ,
                member.getJob(),
                member.getEmail());
    }
}
