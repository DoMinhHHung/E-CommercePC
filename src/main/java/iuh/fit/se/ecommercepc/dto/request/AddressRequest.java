package iuh.fit.se.ecommercepc.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {
    private String fullName;
    private String phoneNumber;
    private String addressLine;
    private String city;
    private String district;
    private String ward;
    private boolean isDefault;
}
