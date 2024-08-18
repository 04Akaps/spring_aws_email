package com.example.demo.domain.auth.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Qr 확인")
public record VerifyQrRequest(
        @Schema(description = "Qr Verify Code")
        @NotBlank 
        @NotNull
        String code,


        @Schema(description = "Qr Verify Code")
        @NotBlank 
        @NotNull
        String email
) {}
