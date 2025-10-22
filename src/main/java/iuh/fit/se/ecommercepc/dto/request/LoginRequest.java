package iuh.fit.se.ecommercepc.dto.request;

import jakarta.validation.constraints.*;

public class LoginRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
