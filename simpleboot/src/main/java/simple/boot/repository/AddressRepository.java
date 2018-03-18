package simple.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import simple.boot.model.Address;

public interface AddressRepository extends JpaRepository<Address, String> {
	Address findByName(String name);
}
