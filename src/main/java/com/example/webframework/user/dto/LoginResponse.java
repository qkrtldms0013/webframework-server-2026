package com.example.webframework.user.dto;

public record LoginResponse(
        String accessToken,
        String tokenType,
        long expiresIn
) {
}
