package iuh.fit.se.ecommercepc.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String fullname;
    private String email;
    private String phone;
    private String password;
}
