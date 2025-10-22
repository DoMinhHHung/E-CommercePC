package iuh.fit.se.ecommercepc.dto.response;

import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String receiverName;
    private String phone;
    private String streetAddress;
    private String ward;
    private String district;
    private String city;
    private boolean isDefault;
}

