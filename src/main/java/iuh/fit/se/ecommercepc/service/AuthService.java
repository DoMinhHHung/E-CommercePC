package iuh.fit.se.ecommercepc.service;

import iuh.fit.se.ecommercepc.dto.request.*;
import iuh.fit.se.ecommercepc.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    void verifyEmail(String token);

    void forgotPassword(ForgotPasswordRequest request);
    void resetPassword(ResetPasswordRequest request);
    void changePassword(ChangePasswordRequest request, String email);
}