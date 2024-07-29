package com.example.demo.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode implements CodeInterface {
    NOT_FIND_EMAIL(-1, "메일을 찾지 못하였습니다.");

    private final Integer code;
    private final String message;
}