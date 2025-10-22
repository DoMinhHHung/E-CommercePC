package iuh.fit.se.ecommercepc.service;

import iuh.fit.se.ecommercepc.dto.request.AddressRequest;
import iuh.fit.se.ecommercepc.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAllAddresses(Long userId);
    AddressResponse addAddress(Long userId, AddressRequest request);
    AddressResponse updateAddress(Long userId, Long addressId, AddressRequest request);
    void deleteAddress(Long userId, Long addressId);
    void setDefaultAddress(Long userId, Long addressId);
}
