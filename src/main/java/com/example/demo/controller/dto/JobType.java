package com.example.demo.controller.dto;

import com.example.demo.exception.CustomException;
import com.example.demo.exception.ExceptionType;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum JobType {
    DEVELOPER("Developer", Arrays.asList("Frontend", "Backend")),
    ENGINEER("Engineer", Arrays.asList("DevOps", "SRE"));

    String name;
    List<String> titles;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static JobType deserialize(String name) {
        for (JobType each : JobType.values()) {
            if (each.getName().equals(name)) {
                return each;
            }
        }
        throw new CustomException(ExceptionType.INVALID_INPUT, "JobType 내 해당하는 Enum 이 존재하지 않습니다. name : " + name);
    }
}