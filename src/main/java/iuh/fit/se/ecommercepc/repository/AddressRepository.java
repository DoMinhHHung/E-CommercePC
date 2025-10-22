package iuh.fit.se.ecommercepc.repository;

import iuh.fit.se.ecommercepc.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
