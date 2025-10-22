package iuh.fit.se.ecommercepc.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRegisterRequest {

    @NotBlank(message = "Họ và tên không được để trống")
    @Size(max = 100, message = "Họ và tên không được quá 100 ký tự")
    private String fullName;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @Pattern(regexp = "^(0|\\+84)\\d{9,10}$", message = "Số điện thoại không hợp lệ")
    private String phone;

    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;

    @NotBlank(message = "Giới tính không được để trống")
    private String gender;

    @Past(message = "Ngày sinh không hợp lệ")
    private String dob;
}
