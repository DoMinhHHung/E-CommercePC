package iuh.fit.se.ecommercepc.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserUpdateRequest {

    @Size(max = 100, message = "Họ và tên không được quá 100 ký tự")
    private String fullName;

    private String gender;

    private String dob;
}