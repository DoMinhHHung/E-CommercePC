package iuh.fit.se.ecommercepc.dto.mapper;

import iuh.fit.se.ecommercepc.dto.request.AddressRequest;
import iuh.fit.se.ecommercepc.dto.response.AddressResponse;
import iuh.fit.se.ecommercepc.entity.Address;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Address toAddress(AddressRequest request);

    AddressResponse toAddressResponse(Address address);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateAddressFromDto(AddressRequest dto, @MappingTarget Address address);
}
