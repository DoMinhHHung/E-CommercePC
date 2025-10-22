package iuh.fit.se.ecommercepc.dto.response;

import iuh.fit.se.ecommercepc.entity.enums.AuthProvider;
import iuh.fit.se.ecommercepc.entity.enums.Role;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String gender;
    private LocalDate dob;
    private Role role;
    private AuthProvider authProvider;
    private boolean enabled;
    private List<AddressResponse> addresses;
}
