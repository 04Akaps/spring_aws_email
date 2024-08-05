package com.example.demo.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode implements CodeInterface {
    NOT_VALID_EMAIL_REQUEST(-1, "잘못된 이메일 형식입니다."),

    REDIS_VALUE_NOT_FOUND(-100, "In Memory에 키가 없습니다.");

    private final Integer code;
    private final String message;
}