package com.example.demo.domain.auth.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.auth.model.response.*;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.demo.common.code.ErrorCode;
import com.example.demo.common.exception.CustomException;
import com.example.demo.common.validator.EmailValidator;
import com.example.demo.domain.auth.model.request.*;
import com.example.demo.domain.repository.*;
import com.example.demo.domain.repository.types.User;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository userRepository;

    @Transactional(transactionManager = "AccountTransactionManager")
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        String email = request.email();

        if (!EmailValidator.isValidEmail(email)) {
            // if not valid email request
            log.error("Failed To Valid Email", email);
            throw new CustomException(ErrorCode.NOT_VALID_EMAIL_REQUEST);
        }else {
            User user = userRepository.findByEmail(email).orElseGet(() -> userRepository.save(
                User.builder()
                .email(email)
                .isValid(false)
                .build()
            ));
    
            log.info("Get From DB", user.getEmail());
        }

        return new CreateAccountResponse(email);
    }
}
