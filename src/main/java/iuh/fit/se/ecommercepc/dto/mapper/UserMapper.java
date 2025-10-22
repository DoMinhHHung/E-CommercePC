package iuh.fit.se.ecommercepc.dto.mapper;

import iuh.fit.se.ecommercepc.dto.request.UserRegisterRequest;
import iuh.fit.se.ecommercepc.dto.request.UserUpdateRequest;
import iuh.fit.se.ecommercepc.dto.response.AddressResponse;
import iuh.fit.se.ecommercepc.dto.response.UserResponse;
import iuh.fit.se.ecommercepc.entity.Address;
import iuh.fit.se.ecommercepc.entity.User;
import org.mapstruct.*;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "dob", source = "dob", qualifiedByName = "mapToLocalDate")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "authProvider", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toUser(UserRegisterRequest request);

    UserResponse toUserResponse(User user);
    AddressResponse toAddressResponse(Address address);
    List<AddressResponse> toAddressResponseList(List<Address> addresses);

    @Mapping(target = "dob", source = "dob", qualifiedByName = "mapToLocalDate")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "authProvider", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateUserFromDto(UserUpdateRequest dto, @MappingTarget User user);

    @Named("mapToLocalDate")
    default LocalDate mapToLocalDate(String dob) {
        if (dob == null || dob.trim().isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(dob);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
