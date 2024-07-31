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

        User user = userRepository.findByEmail(email).orElseGet(() -> userRepository.save(
            User.builder()
            .email(request.email())
            .build()
        ));

        // throw new CustomException(ErrorCode.NOT_FIND_EMAIL);

        System.out.println(user.getEmail());



        // 만약 추가적인 에러처리를 하고 싶다면,
        /*
         *  (user.isPresent()) --> Optinal로 받게 된다면 사용 가능
         * throw new CustomException(ErrorCode.NOT_FIND_EMAIL);
         * 
         */


        return new CreateAccountResponse(request.email());
    }
}
