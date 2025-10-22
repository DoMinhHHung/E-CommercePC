package iuh.fit.se.ecommercepc.service;

import iuh.fit.se.ecommercepc.dto.request.UserUpdateRequest;
import iuh.fit.se.ecommercepc.dto.response.UserResponse;

public interface UserService {
    UserResponse getUserProfile(Long userId);
    UserResponse updateProfile(Long userId, UserUpdateRequest request);
}
