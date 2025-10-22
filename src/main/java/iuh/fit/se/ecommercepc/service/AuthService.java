package iuh.fit.se.ecommercepc.service;

import iuh.fit.se.ecommercepc.dto.request.RegisterRequest;
import iuh.fit.se.ecommercepc.dto.request.LoginRequest;
import iuh.fit.se.ecommercepc.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    void verifyEmail(String token);
}