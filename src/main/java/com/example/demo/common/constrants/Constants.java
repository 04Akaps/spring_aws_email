package com.example.demo.common.constrants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String COMMON_MAIL_SENDER = "sdl182975@gmail.com";
    public static final String QR_SERVER = "https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=otpauth://totp/%s:%s?secret=%s&issuer=%s";
    public static final String OTP_ISSUER = "hong";
    public static final String OTP_SECRET = "SECRET";
}



