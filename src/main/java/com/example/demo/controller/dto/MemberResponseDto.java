package com.example.demo.controller.dto;

import com.example.demo.repository.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponseDto {
    @JsonProperty("userId")
    Integer id;
    @JsonProperty("userName")
    String name;
    Integer age;
    JobType job;
    @JsonIgnore
    String email;
    @DataFormat
    LocalDateTime createdAt;


    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getJob(),
                member.getEmail(),
                member.getCreatedAt());
    }
}
