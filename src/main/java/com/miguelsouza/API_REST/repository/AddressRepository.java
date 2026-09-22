package com.miguelsouza.API_REST.repository;

import com.miguelsouza.API_REST.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
