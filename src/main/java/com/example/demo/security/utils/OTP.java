package com.example.demo.security.utils;

import java.net.URLEncoder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

import static com.example.demo.common.constrants.Constants.GOOGLE_OTP_URL_FORMAT;
import static com.example.demo.common.constrants.Constants.OTP_ISSUER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OTP {

    public static String generateQRCodeURL(String userId, String secretKey) {
        return String.format(
                GOOGLE_OTP_URL_FORMAT,
                URLEncoder.encode(OTP_ISSUER + ":" + userId, StandardCharsets.UTF_8),
                URLEncoder.encode(secretKey, StandardCharsets.UTF_8),
                URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8)
        );
    }

}
