package iuh.fit.se.ecommercepc.service.impl;

import iuh.fit.se.ecommercepc.dto.request.LoginRequest;
import iuh.fit.se.ecommercepc.dto.request.RegisterRequest;
import iuh.fit.se.ecommercepc.dto.response.AuthResponse;
import iuh.fit.se.ecommercepc.entity.User;
import iuh.fit.se.ecommercepc.entity.enums.AuthProvider;
import iuh.fit.se.ecommercepc.entity.enums.Role;
import iuh.fit.se.ecommercepc.service.*;
import iuh.fit.se.ecommercepc.config.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final MailService mailService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userService.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email đã tồn tại!");
        }

        User user = User.builder()
                .fullname(request.getFullname())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .provider(AuthProvider.LOCAL)
                .enabled(false)
                .build();

        userService.save(user);

        String token = jwtTokenProvider.generateToken(user.getEmail());
        mailService.sendVerificationEmail(user.getEmail(), token);

        return AuthResponse.builder()
                .message("Đăng ký thành công! Vui lòng kiểm tra email để xác thực.")
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userService.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        if (!user.isEnabled()) {
            throw new RuntimeException("Tài khoản chưa được xác thực!");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Sai mật khẩu!");
        }

        String token = jwtTokenProvider.generateToken(user.getEmail());
        return AuthResponse.builder()
                .token(token)
                .message("Đăng nhập thành công!")
                .build();
    }

    @Override
    public void verifyEmail(String token) {
        String email = jwtTokenProvider.getEmailFromToken(token);
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user!"));
        user.setEnabled(true);
        userService.save(user);
    }
}
