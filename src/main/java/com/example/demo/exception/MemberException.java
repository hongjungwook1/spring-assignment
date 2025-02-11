package com.example.demo.exception;

public class MemberException extends RuntimeException {
    private final static String message = "유저를 못찾음 id : ";

    public MemberException(Integer id) {
        super(message + id);
    }
}
