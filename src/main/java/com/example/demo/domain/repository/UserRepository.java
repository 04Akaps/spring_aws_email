package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.repository.types.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.is_valid = :isValid WHERE u.email = :email")
    Integer updateIsValidByEmail(@Param("email") String email, @Param("isValid") boolean isValid);
}
