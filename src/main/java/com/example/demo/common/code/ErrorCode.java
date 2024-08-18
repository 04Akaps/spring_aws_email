package com.example.demo.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode implements CodeInterface {
    NOT_VALID_EMAIL_REQUEST(-1, "잘못된 이메일 형식입니다."),
    ALREADY_VALIDED_EMAIL(-2, "이미 유효한 메일 입니다."),
    NOT_FIND_EMAIL(-3, "해당된 이메일 주소를 찾지 못하였습니다."),

    REDIS_VALUE_NOT_FOUND(-100, "In Memory에 키가 없습니다."),

    MAIL_RECEIVER_REQUIRED(-200, "Mail Receiver Required!!"),
    MAIL_SEND_FAILED(-201, "Mail Send Failed");

    private final Integer code;
    private final String message;
}