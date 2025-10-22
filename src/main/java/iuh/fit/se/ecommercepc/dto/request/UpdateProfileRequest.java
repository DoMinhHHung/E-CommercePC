package iuh.fit.se.ecommercepc.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProfileRequest {
    private String fullname;
    private String phone;
    private String gender;
    private LocalDate dob;
}
