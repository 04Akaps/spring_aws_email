package com.example.demo.domain.auth.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.auth.model.request.CreateAccountRequest;
import com.example.demo.domain.auth.model.response.CreateAccountResponse;

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

    @Operation(
        summary = "초대 메일 송신", 
        description = "초대 메일을 전송 합니다. 기존에 존재하지 않는 유저여야 합니다."
    )
    @PostMapping("/invite/{userId}")
    public String sendInviteMail(@PathVariable String userId) {
        return "test";
    }

    @Operation(
        summary = "새로운 유저 생성", 
        description = "새로운 유저를 생성합니다."
    )
    @PostMapping("/make-user/{email}")
    public CreateAccountResponse makeUser(
        @RequestBody @Valid CreateAccountRequest request
    ) {
        
        return new CreateAccountResponse("test");
    }
}
