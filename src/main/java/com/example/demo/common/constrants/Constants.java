package com.example.demo.common.constrants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String COMMON_MAIL_SENDER = "sdl182975@gmail.com";
    public static final String GOOGLE_OTP_URL_FORMAT = "https://www.google.com/chart?chs=200x200&chld=M|0&cht=qr&chl=otpauth://totp/%s?secret=%s&issuer=%s";
    public static final String OTP_ISSUER = "hong";
}
