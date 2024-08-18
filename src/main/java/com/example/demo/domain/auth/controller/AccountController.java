package com.example.demo.domain.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.auth.model.request.SendQrRequest;
import com.example.demo.domain.auth.model.request.VerifyQrRequest;
import com.example.demo.domain.auth.model.response.SendQrResponse;
import com.example.demo.domain.auth.model.response.VerifyQrResponse;
import com.example.demo.domain.auth.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Acoount API", description = "계정 관련 API를 담당합니다.")
@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @Operation(
        summary = "새로운 유저 생성", 
        description = "새로운 유저를 생성합니다."
    )
    @GetMapping("/send-qr/{email}")
    public SendQrResponse sendQr(
        @RequestBody @Valid SendQrRequest request
    ) {
        return accountService.sendQRCode(request);
    }

    public VerifyQrResponse verifyQr(
        @RequestBody @Valid VerifyQrRequest request
    ) {
        return accountService.verifyQr(request);
    }
}
