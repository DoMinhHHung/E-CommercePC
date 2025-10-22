package iuh.fit.se.ecommercepc.service;

import iuh.fit.se.ecommercepc.dto.request.UserLoginRequest;
import iuh.fit.se.ecommercepc.dto.request.UserRegisterRequest;
import iuh.fit.se.ecommercepc.dto.response.UserResponse;
import iuh.fit.se.ecommercepc.entity.User;

public interface AuthService {

    UserResponse register(UserRegisterRequest request);

    UserResponse verifyAccount(String token);

    AuthResponse login(UserLoginRequest request);

    AuthResponse oauth2Login(User oauth2User);

    void forgotPassword(String identifier);

    UserResponse resetPassword(String otp, String newPassword);

    AuthResponse refreshToken(String refreshToken);

    void changePassword(Long userId, String oldPassword, String newPassword);
}