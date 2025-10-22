package iuh.fit.se.ecommercepc.controller;

import iuh.fit.se.ecommercepc.dto.request.*;
import iuh.fit.se.ecommercepc.dto.response.AuthResponse;
import iuh.fit.se.ecommercepc.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/verify")
    public String verify(@RequestParam String token) {
        authService.verifyEmail(token);
        return "Xác thực thành công! Giờ bạn có thể đăng nhập.";
    }
}
