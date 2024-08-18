package com.example.demo.domain.auth.service;

import java.lang.StackWalker.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.auth.model.response.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.demo.common.code.ErrorCode;
import com.example.demo.common.constrants.StatusCode;
import com.example.demo.common.constrants.Constants;
import com.example.demo.common.exception.CustomException;
import com.example.demo.common.validator.EmailValidator;
import com.example.demo.domain.auth.enums.MailTemplate;
import com.example.demo.domain.auth.model.request.*;
import com.example.demo.domain.repository.*;
import com.example.demo.domain.repository.types.User;
import com.example.demo.security.utils.OTP;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository userRepository;
    private final MailService mailService;

    @Transactional(transactionManager = "createAccountTransactionManager")
    public SendQrResponse sendQRCode(SendQrRequest request) {
        String email = request.email();

        if (!EmailValidator.isValidEmail(email)) {
            log.error("Failed To Valid Email {}", email);
            throw new CustomException(ErrorCode.NOT_VALID_EMAIL_REQUEST);
        } else {
            User user = userRepository.findByEmail(email).orElseGet(() -> userRepository.save(
                User.builder()
                .email(email)
                .is_valid(false)
                .build()
            ));
    
            log.info("Get From DB", user.getEmail());

            if (!user.getIs_valid()) {
                String link = OTP.generateQRCodeURL(user.getEmail(), Constants.OTP_SECRET);

                Map<String, String> data = Map.of(
                    "email", user.getEmail(),
                    "link", link
                );

                mailService.sendTemplatedEmail(MailTemplate.OTP_BARCODE.getTemplateName(), data, user.getEmail());
            }else {
                log.error("Already Valid Eamil Request {}", email);
                throw new CustomException(ErrorCode.ALREADY_VALIDED_EMAIL);
            }

        }

        return new SendQrResponse(email);
    }

    @Transactional(transactionManager = "verifyQrTransactionManager")
    public VerifyQrResponse verifyQr(VerifyQrRequest request) {

        if (OTP.validateCode(request.code(),  Constants.OTP_SECRET)) {
            Optional<User> user = userRepository.findByEmail(request.email());

            if (!user.isPresent()) {
                log.error("Failed To Find Email {}", request.email());
                throw new CustomException(ErrorCode.NOT_FIND_EMAIL);
            }else {
                Integer affected = userRepository.updateIsValidByEmail(request.email(), true);
                
                if (affected == 0) {
                    log.error("Already Valid Email Request {}", request.email());
                    throw new CustomException(ErrorCode.ALREADY_VALIDED_EMAIL);
                }
            }

            return new VerifyQrResponse(StatusCode.SUCCESS);   
        }else {
            return new VerifyQrResponse(StatusCode.FAILED);
        }
    }
}
