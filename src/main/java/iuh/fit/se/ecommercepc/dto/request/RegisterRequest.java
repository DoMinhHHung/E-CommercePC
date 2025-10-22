package iuh.fit.se.ecommercepc.dto.request;

import jakarta.validation.constraints.*;

public class RegisterRequest {
    private String fullname;
    @Email
    @NotBlank
    private String email;
    private String phone;
    @NotBlank
    private String password;
    private Gender gender;
    private java.time.LocalDate dob;
}
