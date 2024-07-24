package com.example.demo.domain.auth.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "계정 생성 요청")
public record CreateAccountRequest(
        @Schema(description = "이메일")
        @NotBlank String email
) {}
