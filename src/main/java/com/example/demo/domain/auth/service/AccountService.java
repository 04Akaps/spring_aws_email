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

import com.example.demo.domain.auth.model.request.*;
import com.example.demo.domain.repository.*;
import com.example.demo.domain.repository.types.User;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository userRepository;;

    @Transactional(transactionManager = "AccountTransactionManager")
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        String email = request.email();



        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            // 만약 값이 없다면??
            throw new CustomException()
        }

        // 값이 존재하면 true, 없다면 False
        // if (optional.isPresent()) {
        //     System.out.println("Value is present: " + optional.get());
        // }

        return new CreateAccountResponse(request.email());
    }
}
