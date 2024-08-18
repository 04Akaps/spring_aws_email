package com.example.demo.domain.auth.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Qr 검증 응답")
public record VerifyQrResponse(@Schema(description = "성공 유무") String code) {}
