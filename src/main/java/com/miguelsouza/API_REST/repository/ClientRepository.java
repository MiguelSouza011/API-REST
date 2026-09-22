package com.miguelsouza.API_REST.repository;

import com.miguelsouza.API_REST.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
