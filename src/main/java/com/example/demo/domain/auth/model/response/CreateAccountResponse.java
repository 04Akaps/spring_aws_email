package com.example.demo.domain.auth.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "계정 생성 응답")
public record CreateAccountResponse(@Schema(description = "유저 ID") String email) {}
