package com.example.demo.domain.auth.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.auth.model.response.*;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.demo.domain.auth.model.request.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    // @Transactional(transactionManager = "unaTransactionManager")
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        // String userId = redisService.getData(INVITE.getKey() + request.inviteCode());

        // if(StringUtils.isEmpty(userId)) {
        //     throw new CustomException(ErrorCode.REDIS_VALUE_NOT_FOUND);
        // }

        // Account account = accountRepository.findByUserId(userId).orElseGet(() -> accountRepository.save(
        //         Account.builder()
        //                 .userId(userId)
        //                 .password(passwordEncoder.encode(request.password()))
        //                 .isActive(Boolean.FALSE)
        //                 .build()
        // ));

        // OtpSecretKey otpSecretKey = otpSecretKeyRepository.findByUserId(userId).orElseGet(() -> otpSecretKeyRepository.save(
        //         OtpSecretKey.builder()
        //                 .userId(account.getUserId())
        //                 .secretKey(OTPUtils.generateSecretKey())
        //                 .build())
        // );

        // Optional<Staff> optionalUnaUser = staffRepository.findByStaffId(userId);

        // if(optionalUnaUser.isPresent()) {
        //     throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        // }

        // staffRepository.save(
        //         Staff.builder()
        //                 .staffId(userId)
        //                 .authorities(Set.of(BehaviourAuthority.READ))
        //                 .build()
        // );

        // if(userId.contains("@wemade.com")) {
        //     Map<String, String> templateData = new HashMap<>();
        //     templateData.put("userId", userId);
        //     templateData.put("link", OTPUtils.generateQRCodeURL(userId, otpSecretKey.getSecretKey()));

        //     mailService.sendTemplatedEmail(MailTemplate.OTP_BARCODE.getTemplateName(), templateData, userId);
        // }

        // redisService.deleteData(INVITE.getKey() + request.inviteCode());

        // log.info("account created => userId : {}", userId);
        return new CreateAccountResponse("test");
    }
}
