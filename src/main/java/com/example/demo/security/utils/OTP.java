package com.example.demo.security.utils;

import java.net.URLEncoder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.Base32;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.apache.commons.codec.binary.Hex;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

import static com.example.demo.common.constrants.Constants.QR_SERVER;
import static com.example.demo.common.constrants.Constants.OTP_ISSUER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OTP {

    public static String generateQRCodeURL(String email, String secretKey) {
        return String.format(
            QR_SERVER,
            URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8),
            URLEncoder.encode(email, StandardCharsets.UTF_8),
            URLEncoder.encode(secretKey, StandardCharsets.UTF_8),
            URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8)
        );
    }

    public static boolean validateCode(String inputCode, String secret) {
        String code = getTOTPCode(secret);
        return code.equals(inputCode);
    }

    public static String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

}
