package com.example.demo.domain.redis;

import org.springframework.stereotype.Service;

import com.example.demo.common.code.ErrorCode;
import com.example.demo.common.exception.CustomException;

import java.time.Duration;
import java.util.Optional;

import org.springframework.data.redis.core.RedisTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisService<V> {
    private final RedisTemplate<String, V> redisTemplate;

    // Config로 관리 가능
    private Duration defaultExpireTime = Duration.ofMinutes(5);

    public V getMusetValue(String key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key)).orElseThrow(
            () -> new CustomException(ErrorCode.REDIS_VALUE_NOT_FOUND)
        );
    }

    public V getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setData(String key, V value, Duration expireTime) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expireTime);
    }

    public void setData(String key, V value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, this.defaultExpireTime);
    }
}
