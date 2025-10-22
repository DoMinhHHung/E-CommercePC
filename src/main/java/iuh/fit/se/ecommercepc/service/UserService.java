package iuh.fit.se.ecommercepc.service;

import iuh.fit.se.ecommercepc.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    User save(User user);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
