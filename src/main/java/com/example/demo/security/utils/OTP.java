package com.example.demo.security.utils;

import java.net.URLEncoder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base32;
import org.apache.tomcat.util.bcel.classfile.Constant;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

import static com.example.demo.common.constrants.Constants.GOOGLE_OTP_URL_FORMAT;
import static com.example.demo.common.constrants.Constants.OTP_ISSUER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OTP {

    public static String generateQRCodeURL(String email, String secretKey) {
        Base32 base32 = new Base32();
        String encodedSecret = base32.encodeAsString(secretKey.getBytes());

        String otpAuthURL = String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s",
            URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8),
            URLEncoder.encode(email, StandardCharsets.UTF_8),
            URLEncoder.encode(encodedSecret, StandardCharsets.UTF_8),
            URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8));

        return otpAuthURL;

        // String qrCodeUrl = String.format("https://www.google.com/chart?chs=200x200&chld=M|0&cht=qr&chl=otpauth://totp/%s%%3A%s?secret=%s&issuer=%s",
        //     URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8),
        //     URLEncoder.encode(email, StandardCharsets.UTF_8),
        //     URLEncoder.encode(encodedSecret, StandardCharsets.UTF_8),
        //     URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8));

        // return qrCodeUrl;

        


        // return String.format(
        //         GOOGLE_OTP_URL_FORMAT,
        //         URLEncoder.encode(OTP_ISSUER + ":" + userId, StandardCharsets.UTF_8),
        //         URLEncoder.encode(secretKey, StandardCharsets.UTF_8),
        //         URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8)
        // );
    }

}
